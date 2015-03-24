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
    public String manager;

    public static Finder<Long, Project> find = new Finder<Long, Project>(Long.class, Project.class);
}
