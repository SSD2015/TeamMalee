package controllers;

/**
 * Created by thanyaboontovorapan on 4/17/15 AD.
 */
import play.data.Form;
import play.mvc.*;
import play.libs.Time.CronExpression;
import views.html.TimerPage;

import static play.data.Form.form;

public class TimerController extends Controller{
    public static void stopTimer() {
        if ( Global.stopTimer() ) {
            System.out.println("Time stopped");
        }
        else {
            System.out.println("Time isn't started");
        }
    }

    public static void startTimer(int hour, int minute) {
        stopTimer();
        Global.startTimer(hour, minute);
    }

    public static int getTimeLeftHour() {
        return Global.getTimeLeftHour();
    }

    public static int getTimeLeftMinute() {
        return Global.getTimeLeftMinute();
    }

    public static int getTimeLeftInSec() {
        return Global.nextExecutionInSeconds(getTimeLeftHour(), getTimeLeftMinute());
    }

    @Security.Authenticated(Secured.class)
    public static Result gotoTimerPage() {

        return ok(TimerPage.render());
    }

    @Security.Authenticated(Secured.class)
    public static Result setTime () {
        Form<SetTimeForm> form = form(SetTimeForm.class).bindFromRequest();
        startTimer(form.get().hour, form.get().minute);
        return redirect(routes.TimerController.gotoTimerPage());
    }

    public static class SetTimeForm {
        public int hour;
        public int minute;

    }
}
