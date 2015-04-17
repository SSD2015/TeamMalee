package controllers;

/**
 * Created by thanyaboontovorapan on 4/17/15 AD.
 */
import play.mvc.*;
import play.libs.Time.CronExpression;

public class TimerController extends Controller{
    public static void stopTimer() {
        if ( Global.stopTimer() ) {
            System.out.println("Time stopped");
        }
        else {
            System.out.println("Time isn't started");
        }
    }

    public static Result startTimer(int hour, int minute) {
        stopTimer();
        Global.startTimer(hour, minute);
        return redirect("/");
    }

    public static int getTimeLeft() {
        return Global.getTimeLeft();
    }
}
