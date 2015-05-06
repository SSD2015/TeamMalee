package result;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CriteriaList extends Model {
    @Id
    public Long id;

    public String criteriaName;

    public static Finder<Long, CriteriaList> find = new Finder<Long, CriteriaList>(Long.class,CriteriaList.class);

}

