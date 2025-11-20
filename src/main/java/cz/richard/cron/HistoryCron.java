package cz.richard.cron;

import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.Helpers.History.HistoryFacade;
import org.quartz.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class HistoryCron {
    static void configureJob(Scheduler scheduler, AccountManager accountManager) {
        try {
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("accountManager", accountManager);

            BufferedWriter writer = new BufferedWriter(new FileWriter("abc.txt", true) );
            writer.write("\n-------------------------------------------------------\n");
            writer.write("----------"+ LocalDateTime.now().toString() + "----------------");
            writer.write("\n-------------------------------------------------------\n");
            writer.close();

            JobDetail job = newJob(HistoryFacade.class)
                    .withIdentity("history", "history")
                    .setJobData(jobDataMap)
                    .storeDurably()
                    .build();

            /*Trigger trigger = newTrigger()
                    .withIdentity("historyTrigger", "history")
                    .withSchedule(cronSchedule("0/30 * * * * ?"))
                    .forJob("history", "history")
                    .build();
            scheduler.scheduleJob(job, trigger);*/
            scheduler.addJob(job, true);

        } catch (Exception se) {
            se.printStackTrace();
        }
    }
}
