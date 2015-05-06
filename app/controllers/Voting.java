package controllers;

import com.avaje.ebean.Ebean;
import play.Logger;
import play.mvc.*;
import play.data.Form;
import result.*;
import views.html.*;
import java.util.List;

import java.sql.Time;

import static play.data.Form.form;
import static result.Criteria.findExist;

/**
 * Created by thanyaboontovorapan on 2/28/15 AD.
 */
public class Voting extends Controller{
    @Security.Authenticated(Secured.class)
    public static Result addVote() {
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " requested to add a vote");
        Vote vote = Form.form(Vote.class).bindFromRequest().get();
        vote.voterID = Integer.parseInt(session().get("id"));
        Vote voterVote = (Vote)Vote.findExist(vote.voterID+"", vote.projectID+"");
        Project projectVoted = (Project) Project.find.byId(Long.valueOf(vote.projectID));
        if ( vote.sel1 < 0 || vote.sel1 > 5 || vote.sel2 < 0 || vote.sel2 > 5 || vote.sel3 < 0 || vote.sel3 > 5 || vote.sel4 < 0 || vote.sel4 > 5 || vote.sel5 < 0 || vote.sel5 > 5 ) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " failed to add a vote (Invalid score)");
            return ok(projectPage.render(projectVoted, "Vote Failed, invalid score"));
        }
        if ( TimerController.getTimeLeftInSec() <= 0) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " failed to add a vote (Time's up)");
            return ok(projectPage.render(projectVoted, "Vote is closed!!, failed"));
        }
        if (voterVote == null) {
            vote.save();
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " successfully added a vote");
            return ok(projectPage.render(projectVoted, "Vote succeeded"));
        }
        voterVote.sel1 = vote.sel1;
        voterVote.sel2 = vote.sel2;
        voterVote.sel3 = vote.sel3;
        voterVote.sel4 = vote.sel4;
        voterVote.sel5 = vote.sel5;

        voterVote.update();
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " successfully changed a vote");
        return ok(projectPage.render(projectVoted, "Change voting score succeeded"));
    }


    @Security.Authenticated(Secured.class)
    public static void changeVote() {
        Vote vote = Form.form(Vote.class).bindFromRequest().get();

        Vote oldVote = Vote.find.byId(vote.id);

        oldVote.sel1 = vote.sel1;
        oldVote.sel2 = vote.sel2;
        oldVote.sel3 = vote.sel3;
        oldVote.sel4 = vote.sel4;
        oldVote.sel5 = vote.sel5;

        oldVote.update();

    }
    @Security.Authenticated(Secured.class)
    public static Result VoteCri() {
        Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " requested to vote(criteria)");
        Criteria getCri = Form.form(Criteria.class).bindFromRequest().get();
        getCri.accID = Integer.parseInt(session().get("id"));
        Criteria cri = (Criteria) findExist(getCri.accID + "");
        if (TimerController.getTimeLeftInSec() <= 0) {
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " failed to vote (criteria, vote is closed)");
            return badRequest(criteria.render("Failed, vote is not open"));
        }
        if (cri == null) {
            getCri.save();
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " successfully voted(criteria)");
            return ok(criteria.render("Vote successfully"));
        }
        else {
            cri.projectid = getCri.projectid;
            cri.update();
            Logger.info("User : " + session().get("username") + " Type : " + session().get("type") + " successfully voted(changed criteria)");
            return ok(criteria.render("Change Vote successfully"));
        }

    }

    @Security.Authenticated(Secured.class)
    public static Result changeRatelist() {
        Form<RateListForm> form = form(RateListForm.class).bindFromRequest();
        Logger.info("User : " + session().get("username") + " groupid : " + session().get("groupid") + " requested to change rate list");
        if(!session().get("type").equals("Admin")) {
            Logger.info("User : " + session().get("username") + " groupid : " + session().get("groupid") + " failed to change rate list");
            return redirect("/");
        }
        List<RateList> rates= RateList.find.all();
        RateList tempRate = new RateList();
        tempRate = rates.get(0);
        tempRate.rateName = form.get().rateList1;
        tempRate.update();

        tempRate = rates.get(1);
        tempRate.rateName = form.get().rateList2;
        tempRate.update();

        tempRate = rates.get(2);
        tempRate.rateName = form.get().rateList3;
        tempRate.update();

        tempRate = rates.get(3);
        tempRate.rateName = form.get().rateList4;
        tempRate.update();

        tempRate = rates.get(4);
        tempRate.rateName = form.get().rateList5;
        tempRate.update();
        Logger.info("User : " + session().get("username") + " groupid : " + session().get("groupid") + " successfully changed rate list");
        return redirect("/TimerPage");
    }

    public static class RateListForm {
        public String rateList1;
        public String rateList2;
        public String rateList3;
        public String rateList4;
        public String rateList5;

        public String validate() {
            Http.MultipartFormData data = request().body().asMultipartFormData();
            if (rateList1 == null || rateList2 == null || rateList3 == null || rateList4 == null || rateList5 == null) {
                return "Field is missing";
            }

            return null;
        }
    }
}
