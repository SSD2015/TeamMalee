package controllers;

import play.mvc.*;
import play.data.Form;
import result.Project;
import views.html.*;
import result.Vote;

/**
 * Created by thanyaboontovorapan on 2/28/15 AD.
 */
public class Voting extends Controller{

    public static Result addVote() {
        Vote vote = Form.form(Vote.class).bindFromRequest().get();
        vote.voterID = Integer.parseInt(session().get("id"));
        Vote voterVote = (Vote)Vote.findExist(vote.voterID+"", vote.projectID+"");
        Project projectVoted = (Project) Project.find.byId(Long.valueOf(vote.projectID));
        if (voterVote == null) {
            vote.save();
            return ok(projectPage.render(projectVoted, "Vote succeeded"));
        }
        voterVote.sel1 = vote.sel1;
        voterVote.sel2 = vote.sel2;
        voterVote.sel3 = vote.sel3;

        voterVote.update();
        return ok(projectPage.render(projectVoted, "Change voting score succeeded"));
    }



    public static void changeVote() {
        Vote vote = Form.form(Vote.class).bindFromRequest().get();

        Vote oldVote = Vote.find.byId(vote.id);

        oldVote.sel1 = vote.sel1;
        oldVote.sel2 = vote.sel2;
        oldVote.sel3 = vote.sel3;

        oldVote.update();

    }
}
