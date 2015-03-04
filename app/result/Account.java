package result;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by patawat on 3/3/15 AD.
 */
@Entity
public class Account extends Model {
    @Id
    public Long id;
    public String Username;
    public String Password;
    //public String Name;
    // Finder will help us easily query data from database.
    //public static Finder<Long, Vote> find = new Finder<Long, Vote>(Long.class, Vote.class);
}
