package cz.richard.accounts.Helpers.Cron;
import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.Helpers.InterestFacade;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.Duration;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;


public class InterestCronPackage {

        public static void StartService(AccountManager accountManager) {

            Scheduler scheduler = null;
            try {
                // Grab the Scheduler instance from the Factory
                scheduler = StdSchedulerFactory.getDefaultScheduler();

                // and start it off

                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("accountManager", accountManager);
                jobDataMap.put("period", Duration.ofSeconds(2));

                JobDetail job = newJob(InterestFacadePackage.class)
                        .withIdentity("job1", "group1")
                        .setJobData(jobDataMap)
                        .build();

                // Trigger the job to run now, and then repeat every 2 seconds
                Trigger trigger = newTrigger()
                        .withIdentity("trigger3", "group1")
                        .withSchedule(cronSchedule("0/2 * * * * ?"))
                        .forJob("job1", "group1")
                        .build();
                scheduler.scheduleJob(job, trigger);
                scheduler.start();

            } catch (SchedulerException se) {
                se.printStackTrace();
            }
        }

}
