package result;
import javax.persistence.*;

import play.db.ebean.*;
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

    // Finder will help us easily query data from database.
    public static Finder<Long, Vote> find = new Finder<Long, Vote>(Long.class, Vote.class);
}