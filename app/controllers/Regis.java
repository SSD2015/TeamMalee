package controllers;

import com.avaje.ebean.Ebean;
import play.Logger;
import play.data.Form;
import play.mvc.*;
import result.Account;
import views.html.*;

//import static play.mvc.Results.ok;

/**
 * Created by patawat on 3/3/15 AD.
 */
public class Regis extends Controller {
    @Security.Authenticated(Secured.class)
    public static Result regis() {
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " requested to access to register page");
        if (session().get("type").equals("Admin")) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " successfully accessed to register page");
            return ok(Register.render());
        }
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " failed to access to register page");
        return redirect("/");
    }
    @Security.Authenticated(Secured.class)
    public static Result addNewAcc() {
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " requested to create new account");
        if(!session().get("type").equals("Admin")) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " failed to create new account");
            return redirect("/");
        }
        Account account = Form.form(Account.class).bindFromRequest().get();
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() != null) {
            return ok(login.render(Form.form(Login.class)));
        }

        account.save();
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " successfully created new account");
        return ok(Register.render());
    }
}
