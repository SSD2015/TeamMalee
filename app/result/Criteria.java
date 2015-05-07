package result;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by patawat on 4/18/15 AD.
 */

@Entity
public class Criteria extends Model {
    @Id
    public Long id;

    public String projectid;
    public int accID;
    public int criteriaID;

    public static Finder<Long, Criteria> find = new Finder<Long, Criteria>(Long.class,Criteria.class);
    public static Criteria findExist(String voterID) {

        return Ebean.find(Criteria.class).where()
                .eq("accID", voterID)
                .findUnique();
    }

    public static Criteria findExist(String voterID, String criteriaID) {
        List<Criteria> tempCriteriaList = Criteria.find.all();
        for (int i = 0; i < tempCriteriaList.size(); i++) {
            Criteria tempCriteria = tempCriteriaList.get(i);
            if ( (tempCriteria.accID+"").equals(voterID) && (tempCriteria.criteriaID+"").equals(criteriaID)) {
                return tempCriteria;
            }
        }
        return null;
    }
}



