package result;

/**
 * Created by thanyaboontovorapan on 3/24/15 AD.
 */


import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.*;

@Entity
public class Project extends Model {
    @Id
    public Long id;
    public String name, imageurl, description;
    public Account manager;

    public static Finder<Long, Vote> find = new Finder<Long, Vote>(Long.class, Vote.class);
}
