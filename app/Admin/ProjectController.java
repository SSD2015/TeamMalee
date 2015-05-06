package Admin;

/**
 * Created by patawat on 5/6/15 AD.
 */

import play.data.Form;
import play.mvc.Result;
import Admin.html.projectList;
import result.Account;
import result.Project;

import static play.mvc.Controller.session;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;


public class ProjectController {
    public static Result getProjectList()
    {
        return ok(projectList.render(Project.find.all()));
    }
    public static class DeleteForm{
        public String id;
    }
    public static Result remove() {
        if (!session().get("type").equals("Admin")) {
            redirect("/");
        }
        DeleteForm project = Form.form(DeleteForm.class).bindFromRequest().get();
        if(Project.find.byId((long) Integer.parseInt(project.id))!=null&&!project.id.equals("")) {
            Project.find.byId((long) Integer.parseInt(project.id)).delete();
            return redirect("/projectList");
        }
        return redirect("/projectList");
    }

}
