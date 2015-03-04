package controllers;

import play.mvc.*;
import result.Vote;
import views.html.*;

public class Application extends Controller {
    public static Result index() { return ok(index.render("id")); }
    public static Result votingResult() { return ok(complete.render( Vote.find.all())); }
    public static Result gotoVotePage() { return ok(vote.render("New vote page"));}
}
