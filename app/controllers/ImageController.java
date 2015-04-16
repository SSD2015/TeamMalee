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
import java.util.List;
import java.io.File;

public class ImageController extends Controller {

//    public static Result getImage(long id) {
//        Image image = null;
//        List<Image> imageList = Image.find.all();
//        for(int i = 0; i < imageList.size(); i++) {
//            System.out.println("Size = " + imageList.size());
//            if (imageList.get(i).projectID == id) {
//                System.out.println("Found image");
//                image = imageList.get(i);
//            }
//        }
//
//        if (image != null) {
//
//            /*** here happens the magic ***/
//            return ok(image.data).as("image");
//            /************************** ***/
//
//        } else {
//            return badRequest(projectPage.render(Project.find.byId(id), "Error, Picture not found"));
//        }
//    }

    public static Result uploadImage(long id) {
        Form<UploadImageForm> form = form(UploadImageForm.class).bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(projectPage.render(Project.find.byId(id), "Error occured"));

        } else {
//            new Image(
//                    form.get().image.getFilename(),
//                    form.get().image.getFile(),
//                    id
//            );
            File file = form.get().image.getFile();
            file.renameTo(new File("public/projectimages/", id+".png"));


            return ok(projectPage.render(Project.find.byId(id), "Success"));
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