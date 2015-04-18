package result;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by patawat on 4/18/15 AD.
 */

@Entity
public class Criteria extends Model {
    @Id
    public Long id;
    public String projectid;
    public int accID;

    public static Finder<Long, Criteria> find = new Finder<Long, Criteria>(Long.class,Criteria.class);
    public static Criteria findExist(String voterID) {

        return Ebean.find(Criteria.class).where()
                .eq("accID", voterID)
                .findUnique();
    }


}



