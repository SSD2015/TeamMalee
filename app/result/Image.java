package result;

/**
 * Created by thanyaboontovorapan on 4/19/15 AD.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.data.validation.Constraints;

import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Entity
@Table(name="image")
public class Image extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public long id;

    @Constraints.Required
    public Long projectID;

    @Lob
    public byte[] data;

    public static Finder<Long, Image> find =
            new Finder<Long, Image>(Long.class, Image.class);

    public Image(Long id, File image) {
        this.projectID = id;
        this.data = new byte[(int)image.length()];

        /* write the image data into the byte array */
        InputStream inStream = null;
        try {
            inStream = new BufferedInputStream(new FileInputStream(image));
            inStream.read(this.data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Image oldImage = Image.find.where().eq("projectID", id).findUnique();
        if (oldImage == null) {
            this.save();
        }
    }
}
