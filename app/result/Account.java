package result;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;
import play.data.validation.Constraints;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

/**
 * Created by patawat on 3/3/15 AD.
 */
@Entity
public class Account extends Model {

    @Id
    public Long id;
    @Constraints.Required
    public String username;
    @Constraints.Required
    public String password;
    @Constraints.Required
    public Long groupid;
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String type;

    public static Object authenticate(String username, String password) {
        System.out.println(username + " " + password); // Check if form data is passed.

        return Ebean.find(Account.class).where()
                .eq("username", username)
                .eq("password", password)
                .findUnique();
    }
    public static Account findAccount(String Id){
        return Ebean.find(Account.class).where()
                .eq("id", Id)
                .findUnique();
    }


    public String getType(){
        return this.type;
    }
    //public String Name;
    // Finder will help us easily query data from database.
    public static Finder<Long, Account> find = new Finder<Long, Account>(Long.class, Account.class);
}
