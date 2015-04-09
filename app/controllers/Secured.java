package controllers;

/**
 * Created by patawat on 4/9/15 AD.
 */
import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;


public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {

        return redirect("/");
    }
}