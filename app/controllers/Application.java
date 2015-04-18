package controllers;

import Admin.html.MainAdmin;
import Admin.html.userList;
import play.data.Form;
import play.mvc.*;
import result.*;
import scala.collection.immutable.List;
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
        return ok(userList.render(Account.find.all()));
    }
    @Security.Authenticated(Secured.class)
    public static Result Adminindex() {
        return ok(MainAdmin.render(session().get("name")));
    }
    @Security.Authenticated(Secured.class)
    public static Result votingResult() {
        ArrayList<resultVote> results = new ArrayList<resultVote>();

        for (int i=0;i< Project.find.all().size();i++){
            System.out.print("in");

           results.add(new resultVote(Project.find.byId((long) i+1).name,0,0,0,0));
        }

        for(int i=0;i< Vote.find.all().size();i++){
            Vote resultV = Vote.find.byId((long) i+1);
            resultVote resultPro = (resultVote) results.get(resultV.projectID-1);
            resultPro.setName(Project.find.byId((long) resultV.projectID).name);
            resultPro.setScore(resultV.sel1);
            resultPro.setScore2(resultV.sel2);
            resultPro.setScore3(resultV.sel3);
        }
        for (int i=0;i< Criteria.find.all().size();i++){
            Criteria resultC = Criteria.find.byId((long) i+1);
            resultVote resultPro = (resultVote) results.get(Integer.parseInt(resultC.projectid)-1);
            resultPro.setCriteria(1);
        }
        if(session().get("type").equals("Admin"))
            return ok(complete.render( results));
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
            System.out.println(session().get("type"));
            return redirect("/AdminIndex");
        }
        else {
            System.out.println(session().get("type"));
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
                System.out.println(session().get("type"));
                return redirect("/AdminIndex");
            }
            else {
                System.out.println(session().get("type"));
                return redirect("/index");
            }
        }
    }
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/");
    }

    public static Result AddProject() {
        Project project = Form.form(Project.class).bindFromRequest().get();

        project.save();

        return redirect("/");
    }
    @Security.Authenticated(Secured.class)
    public static Result GotoAddProjectPage() {
        if(session().get("type").equals("Admin"))
            return ok(addproject.render("Add Project"));
        return redirect("/");
    }

    @Security.Authenticated(Secured.class)
    public static Result GotoProjectPage(Long id, String name) {

        return ok(projectPage.render(Project.find.byId(id),""));
    }

    @Security.Authenticated(Secured.class)
    public static Result editDescription(Long id) {
        Form<EditDescriptionForm> form = form(EditDescriptionForm.class).bindFromRequest();

        Project targetProject = Project.find.byId(id);

        targetProject.description = form.get().inputDescription;

        targetProject.update();

        return redirect(routes.Application.GotoProjectPage( targetProject.id , targetProject.name ));
    }

    public static class EditDescriptionForm {
        public String inputDescription;

    }

    public static Result criteria() {
        if (session().isEmpty())
            return ok(login.render(Form.form(Login.class)));
        else
            return ok(criteria.render(session().get("name")));
    }
}






