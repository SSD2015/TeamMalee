package Admin;


import play.data.Form;
import play.mvc.Result;
import result.Account;


import static play.mvc.Results.redirect;

/**
 * Created by patawat on 4/17/15 AD.
 */
public class accController {
    public static Result remove() {
        removeAcc account = Form.form(removeAcc.class).bindFromRequest().get();
        System.out.println(account.id);
        if(Account.findAccount(account.id)!=null&&!account.id.equals("")) {
            Account.find.byId((long) Integer.parseInt(account.id)).delete();
            return redirect("/AccList");
        }
        return redirect("/AccList");
    }
}
