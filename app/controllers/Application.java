package controllers;

import Admin.html.MainAdmin;
import play.data.Form;
import play.mvc.*;
import result.Account;
import result.Vote;
import result.resultVote;
import views.html.*;
import Admin.html.*;
import play.data.*;
import result.Project;

import java.util.ArrayList;

public class Application extends Controller {
    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render(session().get("username")));
    }
    public static Result Adminindex() {
        return ok(MainAdmin.render(session().get("username")));
    }
    @Security.Authenticated(Secured.class)
    public static Result votingResult() {
        ArrayList results = new ArrayList();

        for (int i=0;i< Project.find.all().size();i++){
            System.out.print("in");
           results.add(new resultVote(i,0,0,0));
        }

        for(int i=0;i< Vote.find.all().size();i++){
            Vote resultV = Vote.find.byId((long) i+1);
            resultVote resultPro = (resultVote) results.get(resultV.projectID-1);
            resultPro.setScore(resultV.sel1);
            resultPro.setScore2(resultV.sel2);
            resultPro.setScore3(resultV.sel3);
        }

        return ok(complete.render( results));
    }
    public static Result login() {

        if (session().isEmpty())
            return ok(login.render(Form.form(Login.class)));
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
        return ok(addproject.render("Add Project"));
    }

    @Security.Authenticated(Secured.class)
    public static Result GotoProjectPage(Long id, String name) {

        return ok(projectPage.render(Project.find.byId(id),""));
    }
    @Security.Authenticated(Secured.class)
    public static Result gotoVotePage(Long id, String name) {
        String user = session().get("username");
        //if(user!=null) {
            Project projectVoted = Project.find.byId(id);
            return ok(vote.render(projectVoted));
        //}
        //return redirect("/index");
    }
}




