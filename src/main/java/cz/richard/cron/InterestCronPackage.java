package cz.richard.cron;
import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.Helpers.InterestFacadePackage;
import org.quartz.*;

import java.time.Duration;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;


public class InterestCronPackage {

        static void configureJob(Scheduler scheduler, AccountManager accountManager) {
            try {
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("accountManager", accountManager);
                jobDataMap.put("period", Duration.ofSeconds(2));

                JobDetail job = newJob(InterestFacadePackage.class)
                        .withIdentity("interest", "interest")
                        .setJobData(jobDataMap)
                        .build();

                // Trigger the job to run now, and then repeat every 2 seconds
                Trigger trigger = newTrigger()
                        .withIdentity("interestTrigger", "interest")
                        .withSchedule(cronSchedule("0/5 * * * * ?"))
                        .forJob("interest", "interest")
                        .build();
                scheduler.scheduleJob(job, trigger);

            } catch (SchedulerException se) {
                se.printStackTrace();
            }
        }

}
