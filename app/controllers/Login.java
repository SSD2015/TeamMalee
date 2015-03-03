package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

//import javax.xml.transform.Result;

/**
 * Created by patawat on 3/2/15 AD.
 */

public class Login extends Controller {
    public static Result test(){
        Form<Users> userForm = Form.form(Users.class);
        Users user = userForm.bindFromRequest().get();
        //System.out.print(user.email);
        return ok(index.render("Welcome " + user.email));
    }


}
