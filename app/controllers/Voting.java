package controllers;

import com.avaje.ebean.Ebean;
import play.Logger;
import play.mvc.*;
import play.data.Form;
import result.Account;
import result.Criteria;
import result.Project;
import views.html.*;
import result.Vote;

import java.sql.Time;

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
}
