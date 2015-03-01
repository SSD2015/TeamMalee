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
}
