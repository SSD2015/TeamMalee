package controllers;

import org.h2.engine.User;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import result.Users;
import result.Vote;
import views.html.*;
import models.*;



public class Application extends Controller {
    public static Result index() { return ok(index.render("id")); }
    public static Result votingResult() { return ok(complete.render( Vote.find.all())); }
    public static Result gotoVotePage() { return ok(vote.render("New vote page"));}
    public static Result login() {
        return ok(
                login.render()
        );
    }
    public static Result authenticate() {
        Form<Login> userForm = Form.form(Login.class);
        Login user = userForm.bindFromRequest().get();
        return ok();
    }
}
public class Login extends Model {

    public String email;
    public String password;

    public String validate() {
        if (User.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }
}



