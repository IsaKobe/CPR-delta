package cz.richard.cron;

import cz.richard.accounts.Helpers.AccountManager;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.listeners.JobChainingJobListener;

public class CronServices {
    public static void StartCronService(AccountManager accountManager) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            InterestCronPackage.configureJob(scheduler, accountManager);
            HistoryCron.configureJob(scheduler, accountManager);

            JobChainingJobListener chain = new JobChainingJobListener("chain");
            chain.addJobChainLink(JobKey.jobKey("interest", "interest"), JobKey.jobKey("history", "history"));
            scheduler.getListenerManager().addJobListener(chain);

            scheduler.start();
            System.out.println("-------------------------Scheduler started-------------------------");
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
