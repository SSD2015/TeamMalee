package controllers;

import play.db.ebean.Model;
import result.Account;

/**
 * Created by patawat on 3/8/15 AD.
 */
public class Login extends Model {
    public String username;
    public String password;

    public String validate() {
        if (Account.authenticate(username, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }

}