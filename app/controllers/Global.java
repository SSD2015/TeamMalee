package controllers; /**
 * Created by thanyaboontovorapan on 4/17/15 AD.
 */
import akka.actor.Cancellable;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Akka;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import scala.concurrent.duration.FiniteDuration;
import scala.concurrent.duration.Duration;
import play.libs.Time.CronExpression;
import org.joda.time.DateTime;
import org.joda.time.Seconds;


public class Global extends GlobalSettings {
    private static Cancellable scheduler;
    private static Date nextValidTimeAfter;
    private static int timeLeft;

    @Override
    public void onStart(Application application) {
        super.onStart(application);
        System.out.println("System started");
        //schedule();
    }

    @Override
    public void onStop(Application application) {
        //Stop the scheduler
        if (scheduler != null) {
            scheduler.cancel();
        }
    }

    public static int nextExecutionInSeconds(int hour, int minute){
        return Seconds.secondsBetween(
                new DateTime(),
                nextExecution(hour, minute)
        ).getSeconds();
    }

    public static DateTime nextExecution(int hour, int minute){
        DateTime next = new DateTime()
                .withHourOfDay(hour)
                .withMinuteOfHour(minute)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        return (next.isBeforeNow())
                ? next.plusHours(24)
                : next;
    }

    public static boolean stopTimer() {
        if (scheduler != null) {
            scheduler.cancel();
            return true;
        }
        return false;
    }


    public static void startTimer(int hour, int minute) {
        schedule(hour, minute);
    }

    public static int getTimeLeft() {
        return timeLeft;
    }

    private static void schedule(int hour, int minute) {
        try {
            CronExpression e = new CronExpression("0 " + minute + " " + hour + " ? * *");
            nextValidTimeAfter = e.getNextValidTimeAfter(new Date());
            timeLeft = nextExecutionInSeconds(hour, minute);
            FiniteDuration d = Duration.create(
                    nextValidTimeAfter.getTime() - System.currentTimeMillis(),
                    TimeUnit.MILLISECONDS);

            System.out.println("Scheduling to run at " + nextValidTimeAfter);

            scheduler = Akka.system().scheduler().scheduleOnce(d, new Runnable() {

                @Override
                public void run() {
                    System.out.println("Ruuning scheduler");

                    //schedule(); //Schedule for next time

                }
            }, Akka.system().dispatcher());
        } catch (Exception e) {
            Logger.error("", e);
        }
    }
}