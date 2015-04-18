package result;
import javax.persistence.*;

import com.avaje.ebean.Ebean;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;
/**
 * Created by thanyaboontovorapan on 2/28/15 AD.
 */
@Entity
public class Vote extends Model {
    @Id
    public Long id;
    public int sel1;
    public int sel2;
    public int sel3;
    public int sel4;
    public int sel5;
    public int projectID;
    public int voterID;

    // Finder will help us easily query data from database.
    public static Finder<Long, Vote> find = new Finder<Long, Vote>(Long.class, Vote.class);

    public static Vote findExist(String voterID, String projectID) {

        return Ebean.find(Vote.class).where()
                .eq("voterID", voterID)
                .eq("projectID", projectID)
                .findUnique();
    }

}