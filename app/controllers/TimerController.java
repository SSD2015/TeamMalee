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
    @Security.Authenticated(Secured.class)
    public static Result stopTimer() {
        if (!session().get("type").equals("Admin")) {
            return redirect("/index");
        }
        Global.stopTimer();
        return redirect(routes.TimerController.gotoTimerPage());
    }
    @Security.Authenticated(Secured.class)
    public static void startTimer(int hour, int minute) {
        if (session().get("type").equals("Admin")) {
            stopTimer();
            Global.startTimer(hour, minute);
        }

    }

    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String temp = dateFormat.format(date);
        temp = "2015" + temp.substring(4);
        return temp;
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
        if (!session().get("type").equals("Admin")) {
            return redirect("/index");
        }
        return ok(TimerPage.render());
    }

    @Security.Authenticated(Secured.class)
    public static Result setTime () {
        if(!session().get("type").equals("Admin")) {
            return redirect("/");
        }
        Form<SetTimeForm> form = form(SetTimeForm.class).bindFromRequest();
        startTimer(form.get().hour, form.get().minute);
        return redirect(routes.TimerController.gotoTimerPage());
    }

    public static class SetTimeForm {
        public int hour;
        public int minute;

    }
}
