package controllers;

import Admin.html.MainAdmin;
import Admin.html.userList;
import com.avaje.ebean.Ebean;
import play.Logger;
import play.data.Form;
import play.mvc.*;
import result.*;
import java.util.List;
import views.html.*;
import Admin.html.*;
import play.data.*;

import java.util.ArrayList;

import static play.data.Form.form;

public class Application extends Controller {
    @Security.Authenticated(Secured.class)
    public static Result index() {
        if(session().get("type").equals("Admin")){
            return redirect("/AdminIndex");
        }
        return ok(index.render(session().get("name")));
    }

    @Security.Authenticated(Secured.class)
    public static Result accList() {
        if (!session().get("type").equals("Admin")) {
            return redirect("/index");
        }
        Logger.info("User : " + session().get("username") + " Type " + session().get("type") + " accessed to account list page");
        return ok(userList.render(Account.find.all()));
    }

    @Security.Authenticated(Secured.class)
    public static Result Adminindex() {
        if (!session().get("type").equals("Admin")) {
            return redirect("/index");
        }
        Logger.info("User : " + session().get("username") + " Type " + session().get("type") + " accessed to admin index page");
        return ok(MainAdmin.render(session().get("name")));
    }

    @Security.Authenticated(Secured.class)
    public static Result votingResult() {
        long maxindexProject = 0;
        long maxindexVote = 0;
        long maxindexCriteria = 0;
        List<resultVote> results = new ArrayList<resultVote>();

        List<Project> projectList= Project.find.all();
        if(projectList.size() > 0) {
            maxindexProject = projectList.get(projectList.size() - 1).id;
        }

        List<Vote> voteList= Vote.find.all();
        if(voteList.size() > 0) {
            maxindexVote = voteList.get(voteList.size() - 1).id;
        }

        List<Criteria> criteriaList= Criteria.find.all();
        if(criteriaList.size() > 0) {
            maxindexCriteria = criteriaList.get(criteriaList.size() - 1).id;
        }
        for (int i=0;i<= maxindexProject;i++) {
            results.add(new resultVote("Empty", 0));
        }
        for (int i=0;i< maxindexProject;i++){
            Project tempProject = Project.find.byId((long)i+1);
            if ( tempProject != null ) {
                resultVote temp = new resultVote(tempProject.name, 0);
                results.remove(i+1);
                results.add(i+1, temp);
            }
        }
        // Come back to clean code
        for(int i=0;i< maxindexVote;i++){
            Vote resultV = Vote.find.byId((long) i+1);
            if (resultV != null) {
                resultVote resultPro = (resultVote) results.get(resultV.projectID);
                resultPro.setName(Project.find.byId((long) resultV.projectID).name);
                resultPro.setScore(resultV.sel1);
                resultPro.setScore2(resultV.sel2);
                resultPro.setScore3(resultV.sel3);
                resultPro.setScore4(resultV.sel4);
                resultPro.setScore5(resultV.sel5);
            }
        }
        for (int i=0;i< maxindexCriteria;i++){
            Criteria resultC = Criteria.find.byId((long) i+1);
            if(resultC != null) {
                resultVote resultPro = (resultVote) results.get(Integer.parseInt(resultC.projectid));
                resultPro.setCriteria(1, resultC.criteriaID);
            }
        }
        if(TimerController.getTimeLeftInSec() == -1 || session().get("type").equals("Admin")) {
            Logger.info("User : " + session().get("username") + " Type " + session().get("type") + " accessed to voting result page");
            return ok(complete.render(results));
        }
        Logger.info("User : " + session().get("username") + " Type " + session().get("type") + " failed to accessing to voting result page(Vote is not close)");
        return redirect("/");
    }

    public static Result login() {

        if (session().isEmpty())
            return ok(login.render(Form.form(Login.class)));
        else if (session().get("type") == null) {
            session().clear();
            return redirect("/");
        }
        else if (session().get("type").equals("Admin")){
            return redirect("/index");
        }
        else {
            return redirect("/index");
        }
    }

    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        }
        else {
            Account user = (Account)Account.authenticate(loginForm.get().username, loginForm.get().password);
            session().clear();
            session("username", loginForm.get().username);
            session("id", ""+user.id);
            session("type",user.type);
            session("groupid", ""+user.groupid);
            session("name", user.name);
            if (session().get("type").equals("Admin")){
                Logger.info("User : " + session().get("username") + " logged in as admin");
                return redirect("/AdminIndex");
            }
            else {
                Logger.info("User : " + session().get("username") + " logged in as voter");
                return redirect("/index");
            }
        }
    }
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/");
    }
    @Security.Authenticated(Secured.class)
    public static Result AddProject() {
        if(!session().get("type").equals("Admin")) {
            return redirect("/");
        }
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " requested to add project");
        Project project = Form.form(Project.class).bindFromRequest().get();
        if ( project.name.length() <= 0 || project.manager.length() <= 0 ) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " failed to add project (null team name or manager)");
            return badRequest(addproject.render("Please at least fill in project name and project manager username"));
        }
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            System.out.println(project.name.length());
            project.save();
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " project added successfully");
        }

        return redirect("/");
    }
    @Security.Authenticated(Secured.class)
    public static Result GotoAddProjectPage() {
        if(session().get("type").equals("Admin")) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " accessed to add project page");
            return ok(addproject.render(""));
        }
        return redirect("/");
    }

    @Security.Authenticated(Secured.class)
    public static Result GotoProjectPage(Long id, String name) {

        return ok(projectPage.render(Project.find.byId(id),""));
    }

    @Security.Authenticated(Secured.class)
    public static Result editDescription(Long id) {
        Logger.info("User : " + session().get("username") + " groupid : " + session().get("groupid") + " requested to edit description of project id : " + id);
        if(!session().get("groupid").equals(""+id) && !session().get("type").equals("Admin")) {
            Logger.info("User : " + session().get("username") + " groupid : " + session().get("groupid") + " failed to edit description of project id : " + id);
            return redirect("/");
        }
        Form<EditDescriptionForm> form = form(EditDescriptionForm.class).bindFromRequest();

        Project targetProject = Project.find.byId(id);

        targetProject.description = form.get().inputDescription;

        targetProject.update();

        Logger.info("User : " + session().get("username") + " groupid : " + session().get("groupid") + " successfully edit description of project id : " + id);

        return redirect(routes.Application.GotoProjectPage( targetProject.id , targetProject.name ));
    }

    public static class EditDescriptionForm {
        public String inputDescription;

    }
    @Security.Authenticated(Secured.class)
    public static Result criteria() {
        if (session().isEmpty())
            return ok(login.render(Form.form(Login.class)));
        else
            return ok(criteria.render(""));
    }
}






