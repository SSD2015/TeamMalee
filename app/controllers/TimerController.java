package controllers;

/**
 * Created by thanyaboontovorapan on 4/17/15 AD.
 */
import play.data.Form;
import play.mvc.*;
import play.libs.Time.CronExpression;
import views.html.TimerPage;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static play.data.Form.form;

public class TimerController extends Controller{
    public static Result stopTimer() {
        Global.stopTimer();
        return redirect(routes.TimerController.gotoTimerPage());
    }

    public static void startTimer(int hour, int minute) {
        stopTimer();
        Global.startTimer(hour, minute);
    }

    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static int getTimeLeftHour() {
        return Global.getTimeLeftHour();
    }

    public static int getTimeLeftMinute() {
        return Global.getTimeLeftMinute();
    }

    public static int getTimeLeftInSec() {
        int temp = Global.nextExecutionInSeconds(getTimeLeftHour(), getTimeLeftMinute());
        return temp;
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
