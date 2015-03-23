package result;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;
import play.data.validation.Constraints;
import play.db.ebean.*;

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

    public static Object authenticate(String username, String password) {
        System.out.println(username + " " + password); // Check if form data is passed.

        return Ebean.find(Account.class).where()
                .eq("username", username)
                .eq("password", password)
                .findUnique();
    }


    //public String Name;
    // Finder will help us easily query data from database.
    //public static Finder<Long, Vote> find = new Finder<Long, Vote>(Long.class, Vote.class);
}
