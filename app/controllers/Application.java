package controllers;

import play.data.Form;
import play.mvc.*;
import result.Account;
import result.Vote;
import views.html.*;
import play.data.*;
import result.Project;

public class Application extends Controller {
    public static Result index() {
        if(!session().isEmpty()) {
            return ok(index.render(session().get("username")));
        }
        return redirect("/");
    }
    public static Result votingResult() {
        if (session().isEmpty())
            return redirect("/");
        return ok(complete.render( Vote.find.all()));
    }
    public static Result login() {
        if (session().isEmpty())
            return ok(login.render(Form.form(Login.class)));
        else
            return redirect("/index");
    }

    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            Account user = (Account)Account.authenticate(loginForm.get().username, loginForm.get().password);
            session().clear();
            session("username", loginForm.get().username);
            session("id", ""+user.id);
            return redirect("/index");
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

    public static Result GotoAddProjectPage() {
        if(session().isEmpty()){
            return redirect("/");
        }
        return ok(addproject.render("Hi"));
    }


    public static Result GotoProjectPage(Long id, String name) {
        if (session().isEmpty()){
            return redirect("/");
        }
        return ok(projectPage.render(Project.find.byId(id),""));
    }

    public static Result gotoVotePage(Long id, String name) {
        String user = session().get("username");
        if(user!=null) {
            Project projectVoted = Project.find.byId(id);
            return ok(vote.render(projectVoted));
        }
        return redirect("/index");
    }
}




