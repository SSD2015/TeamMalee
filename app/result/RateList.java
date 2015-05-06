package result;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RateList extends Model {
    @Id
    public Long id;

    public String rateName;

    public static Finder<Long, RateList> find = new Finder<Long, RateList>(Long.class,RateList.class);

}

