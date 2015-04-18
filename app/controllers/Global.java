package controllers; /**
 * Created by thanyaboontovorapan on 4/17/15 AD.
 */
import akka.actor.Cancellable;
import com.avaje.ebean.Ebean;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.data.Form;
import play.libs.Akka;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import play.mvc.Result;
import result.Account;
import result.Project;
import scala.concurrent.duration.FiniteDuration;
import scala.concurrent.duration.Duration;
import play.libs.Time.CronExpression;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import views.html.Register;
import views.html.login;


public class Global extends GlobalSettings {
    private static Cancellable scheduler;
    private static Date nextValidTimeAfter;
    private static int timeLeftHour = -1;
    private static int timeLeftMinute = -1;

    @Override
    public void onStart(Application application) {
        super.onStart(application);
        System.out.println("System started");
        firstAccount();
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
        if (hour == -1 || minute == -1) {
            return -1;
        }
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

    public static void firstAccount() {
        int i = 0;
        Account account = new Account();
        account.id = (long)++i;
        account.username = "admin";
        account.password = "firstadmin";
        account.type = "Admin";
        account.name = "Administrator";
        account.groupid = (long)-1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //------------------------GG
        account = new Account();
        account.id = (long)++i;
        account.username = "5610545757";
        account.password = "manatsawin.h@ku.th";
        account.type = "Voter";
        account.name = "Win";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546770";
        account.password = "varis.k@ku.th";
        account.type = "Voter";
        account.name = "Win";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610545749";
        account.password = "pongsachon.p@ku.th";
        account.type = "Voter";
        account.name = "Tan";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //-----------------TheFrank
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546681";
        account.password = "kittinan.n@ku.th";
        account.type = "Voter";
        account.name = "Kit";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546281";
        account.password = "perawith.j@ku.th";
        account.type = "Voter";
        account.name = "Boss";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546753";
        account.password = "nathis.y@ku.th";
        account.type = "Voter";
        account.name = "New";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610545692";
        account.password = "thanachote.v@ku.th";
        account.type = "Voter";
        account.name = "Frank";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546729";
        account.password = "thanaphon.k@ku.th";
        account.type = "Voter";
        account.name = "Mo";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //--------------------Malee
        account = new Account();
        account.id = (long)++i;
        account.username = "5610545048";
        account.password = "tanatorn.a@ku.th";
        account.type = "Voter";
        account.name = "Neen";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610545714";
        account.password = "patawat.w@ku.th";
        account.type = "Voter";
        account.name = "Boss";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546745";
        account.password = "thanyaboon.t@ku.th";
        account.type = "Voter";
        account.name = "Chao";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5610546761";
        account.password = "mintra.t@ku.th";
        account.type = "Voter";
        account.name = "Mint";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //--------------------JDED
        account = new Account();
        account.id = (long)++i;
        account.username = "5410545044";
        account.password = "waranyu.r@ku.th";
        account.type = "Voter";
        account.name = "Waranyu";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5410545052";
        account.password = "supayut.r@ku.th";
        account.type = "Voter";
        account.name = "Supayut";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5410546334";
        account.password = "wasin.h@ku.th";
        account.type = "Voter";
        account.name = "Wasin";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5410546393";
        account.password = "akkarawit.p@ku.th";
        account.type = "Voter";
        account.name = "Akkarawit";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)++i;
        account.username = "5410547594";
        account.password = "nachanok.s@ku.th";
        account.type = "Voter";
        account.name = "Nachanok";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }


        //----------------------Team!!!!!!!!!!! GG
        Project project = new Project();
        project.id = (long)1;
        project.name = "GG";
        project.manager = "5610545757";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
        //----------------------Team!!!!!!!!!!! TheFrank
        project = new Project();
        project.id = (long)2;
        project.name = "TheFrank";
        project.manager = "5610546681";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
        //----------------------Team!!!!!!!!!!! Malee
        project = new Project();
        project.id = (long)3;
        project.name = "Malee";
        project.manager = "5610545048";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
        //----------------------Team!!!!!!!!!!! JDED
        project = new Project();
        project.id = (long)4;
        project.name = "JDED";
        project.manager = "5410545044";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
    }

    public static boolean stopTimer() {
        timeLeftHour = -1;
        timeLeftMinute = -1;
        if (scheduler != null) {
            scheduler.cancel();
            return true;
        }
        return false;
    }


    public static void startTimer(int hour, int minute) {
        schedule(hour, minute);
    }

    public static int getTimeLeftHour() {
        return timeLeftHour;
    }

    public static int getTimeLeftMinute() {
        return timeLeftMinute;
    }

    private static void schedule(int hour, int minute) {
        try {
            CronExpression e = new CronExpression("0 " + minute + " " + hour + " ? * *");
            nextValidTimeAfter = e.getNextValidTimeAfter(new Date());
            timeLeftHour = hour;
            timeLeftMinute = minute;
            FiniteDuration d = Duration.create(
                    nextValidTimeAfter.getTime() - System.currentTimeMillis(),
                    TimeUnit.MILLISECONDS);

            System.out.println("Scheduling to run at " + nextValidTimeAfter);
            scheduler = Akka.system().scheduler().scheduleOnce(d, new Runnable() {

                @Override
                public void run() {
                    System.out.println("Ruuning scheduler");

                    //schedule(); //Schedule for next time
                    stopTimer();
                }
            }, Akka.system().dispatcher());
        } catch (Exception e) {
            Logger.error("", e);
        }
    }
}