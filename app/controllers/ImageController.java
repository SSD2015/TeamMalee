package controllers;

/**
 * Created by thanyaboontovorapan on 4/17/15 AD.
 */
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.FilePart;

import play.data.Form;
import static play.data.Form.form;

import result.Project;
import views.html.*;
import java.io.File;
import models.Image;

public class ImageController extends Controller {

    public static Result getImage(long id) {
        Image image = Image.find.where().eq("projectID", id).findUnique();

        if (image != null) {

            /*** here happens the magic ***/
            return ok(image.data).as("image");
            /************************** ***/

        } else {
            return badRequest(projectPage.render(Project.find.byId(id), "Picture not found"));
        }
    }

    public static boolean checkExist(long id) {
        Image image = Image.find.where().eq("projectID", id).findUnique();
        if ( image != null ) {
            return true;
        }
        return false;
    }
    public static Result uploadImage(long id) {
        Form<UploadImageForm> form = form(UploadImageForm.class).bindFromRequest();


        if (form.hasErrors()) {
            return badRequest(projectPage.render(Project.find.byId(id), "Error occured"));

        } else {
            Image oldImage = Image.find.where().eq("projectID", id).findUnique();
            if (oldImage != null) {
                oldImage.delete("secondary");
            }
            new Image(
                    id,
                    form.get().image.getFile()
            );
//            File checker = new File("public/projectimages");
//            if ( !checker.exists() ) {
//                checker.mkdir();
//            }
//            System.out.println("Project id = " + id);
//            File file = form.get().image.getFile();
//            file.renameTo(new File("public/projectimages/", id+".png"));


            return redirect("/");
        }
    }

    public static class UploadImageForm {
        public FilePart image;

        public String validate() {
            MultipartFormData data = request().body().asMultipartFormData();
            image = data.getFile("image");
            if (image == null) {
                return "File is missing.";
            }

            return null;
        }
    }
}