package controllers;

import play.data.Form;
import play.mvc.*;
import result.Account;
import result.Vote;
import views.html.*;
import play.data.*;

public class Application extends Controller {
    public static Result index() { return ok(index.render("id")); }
    public static Result votingResult() { return ok(complete.render( Vote.find.all())); }
    public static Result gotoVotePage() { return ok(vote.render("New vote page"));}
    public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }
    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("username", loginForm.get().username);
            return ok(vote.render(session().get("username")));
        }
    }
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/");
    }


}




