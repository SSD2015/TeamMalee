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
        Account account = new Account();
        account.id = (long)1;
        account.username = "admin";
        account.password = "firstadmin";
        account.type = "Admin";
        account.name = "Administrator";
        account.groupid = (long)-1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //------------------------Saint4
        account = new Account();
        account.id = (long)2;
        account.username = "5610545765";
        account.password = "muninthorn.t@ku.th";
        account.type = "Voter";
        account.name = "Saint";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)3;
        account.username = "5610545781";
        account.password = "runyasak.c@ku.th";
        account.type = "Voter";
        account.name = "JL-SMALLDICK";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)4;
        account.username = "5610545706";
        account.password = "nara.s@ku.th";
        account.type = "Voter";
        account.name = "Job";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)5;
        account.username = "5610546788";
        account.password = "vasupol.c@ku.th";
        account.type = "Voter";
        account.name = "Spa";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)6;
        account.username = "5610545803";
        account.password = "wuttipong.k@ku.th";
        account.type = "Voter";
        account.name = "Best";
        account.groupid = (long)1;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //-----------------Manat
        account = new Account();
        account.id = (long)7;
        account.username = "5610546231";
        account.password = "chinnaporn.s@ku.th";
        account.type = "Voter";
        account.name = "Chin";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)8;
        account.username = "5610545811";
        account.password = "sorrawit.c@ku.th";
        account.type = "Voter";
        account.name = "Ong";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)9;
        account.username = "5610546290";
        account.password = "worapon.o@ku.th";
        account.type = "Voter";
        account.name = "Smart";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)10;
        account.username = "5610545013";
        account.password = "niti.p@ku.th";
        account.type = "Voter";
        account.name = "Kong";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)11;
        account.username = "5610546800";
        account.password = "supason.k@ku.th";
        account.type = "Voter";
        account.name = "Jeng";
        account.groupid = (long)2;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //--------------------2Big2Slim
        account = new Account();
        account.id = (long)12;
        account.username = "5610545722";
        account.password = "punpikorn.r@ku.th";
        account.type = "Voter";
        account.name = "PP";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)13;
        account.username = "5610545668";
        account.password = "nathakorn.s@ku.th";
        account.type = "Voter";
        account.name = "Korn";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)14;
        account.username = "5610545731";
        account.password = "piyaphat.t@ku.th";
        account.type = "Voter";
        account.name = "Pat";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)15;
        account.username = "5610546711";
        account.password = "naphat.y@ku.th";
        account.type = "Voter";
        account.name = "New";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)16;
        account.username = "5610545676";
        account.password = "nut.k@ku.th";
        account.type = "Voter";
        account.name = "Nut";
        account.groupid = (long)3;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //--------------------FatCat
        account = new Account();
        account.id = (long)17;
        account.username = "5610546702";
        account.password = "jiratchaya.i@ku.th";
        account.type = "Voter";
        account.name = "Fern";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)18;
        account.username = "5610545684";
        account.password = "nichamon.h@ku.th";
        account.type = "Voter";
        account.name = "Pang";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)19;
        account.username = "5610546222";
        account.password = "chonnipa.k@ku.th";
        account.type = "Voter";
        account.name = "June";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)20;
        account.username = "5610546257";
        account.password = "natchanon.c@ku.th";
        account.type = "Voter";
        account.name = "Non";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        account = new Account();
        account.id = (long)21;
        account.username = "5610546699";
        account.password = "kittipat.p@ku.th";
        account.type = "Voter";
        account.name = "Maxmi";
        account.groupid = (long)4;
        if ( Ebean.find(Account.class).where().eq("username", account.username).findUnique() == null) {
            account.save();
        }
        //----------------------Team!!!!!!!!!!! Saint4
        Project project = new Project();
        project.id = (long)1;
        project.name = "Saint4";
        project.manager = "5610545765";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
        //----------------------Team!!!!!!!!!!! Manat
        project = new Project();
        project.id = (long)2;
        project.name = "Manat";
        project.manager = "5610546231";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
        //----------------------Team!!!!!!!!!!! 2Big2Slim
        project = new Project();
        project.id = (long)3;
        project.name = "2Big2Slim";
        project.manager = "5610545722";
        if ( Ebean.find(Project.class).where().eq("name", project.name).findUnique() == null) {
            project.save();
        }
        //----------------------Team!!!!!!!!!!! FatCat
        project = new Project();
        project.id = (long)4;
        project.name = "FatCat";
        project.manager = "5610546702";
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