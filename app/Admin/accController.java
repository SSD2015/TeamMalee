package Admin;


import controllers.Secured;
import play.data.Form;
import play.mvc.Result;
import play.mvc.*;
import play.mvc.Security;
import result.Account;


import static play.mvc.Results.redirect;

/**
 * Created by patawat on 4/17/15 AD.
 */
@Security.Authenticated(Secured.class)
public class accController extends Controller{
    public static Result remove() {
        if (!session().get("type").equals("Admin")) {
            redirect("/");
        }
        removeAcc account = Form.form(removeAcc.class).bindFromRequest().get();
        System.out.println(account.id);
        if(Account.findAccount(account.id)!=null&&!account.id.equals("")) {
            Account.find.byId((long) Integer.parseInt(account.id)).delete();
            return redirect("/AccList");
        }
        return redirect("/AccList");
    }
}
