package controllers;

import play.*;
import play.mvc.*;

import result.Vote;
import scala.collection.immutable.List;
import views.html.*;

public class Application extends Controller {
    public static Result index() { return ok(index.render("Your new application is ready!!!!")); }
    public static Result votingresult() { return ok(complete.render( Vote.find.all())); }
    public static Result gotoVotePage() { return ok(vote.render("New vote page"));}
}
