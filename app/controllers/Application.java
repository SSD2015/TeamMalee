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
    public static Result gotoVotePage() {
        String user = session().get("username");
        if(user!=null)
            return ok(vote.render(user));
        else
            return redirect("/index");

    }
    public static Result login() {
        if (session().isEmpty())
            return ok(login.render(Form.form(Login.class)));
        else
            return ok(index.render(session().get("username")));
    }

    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("username", loginForm.get().username);
            return ok(index.render(session().get("username")));
        }
    }
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/");
    }


}




