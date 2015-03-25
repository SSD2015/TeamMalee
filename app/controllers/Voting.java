package controllers;

import play.mvc.*;
import play.data.Form;
import views.html.*;
import result.Vote;

/**
 * Created by thanyaboontovorapan on 2/28/15 AD.
 */
public class Voting extends Controller{

    public static Result addVote() {
        Vote vote = Form.form(Vote.class).bindFromRequest().get();

        vote.save();

        return ok(complete.render(Vote.find.all()));
    }



    public static Result changeVote() {
        Vote vote = Form.form(Vote.class).bindFromRequest().get();

        Vote oldVote = Vote.find.byId(vote.id);

        oldVote.sel1 = vote.sel1;
        oldVote.sel2 = vote.sel2;
        oldVote.sel3 = vote.sel3;

        oldVote.update();

        return ok(changevotescore.render(Vote.find.all()));
    }

    public static Result changeVotePage(){
        if(session().isEmpty())
            return redirect("/");
            return ok(changevotescore.render(Vote.find.all()));
    }

}
