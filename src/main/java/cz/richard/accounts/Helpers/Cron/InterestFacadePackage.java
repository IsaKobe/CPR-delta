package cz.richard.accounts.Helpers.Cron;

import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.InterestAccount;
import cz.richard.accounts.Helpers.AccountInterestService;
import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.Helpers.AccountMovementService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;
import java.util.List;

public class InterestFacadePackage implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        AccountManager manager = (AccountManager) map.get("accountManager");
        Duration period = (Duration) map.get("period");

        List<Account> interestAccounts = manager.getAccounts().stream().filter(account -> account instanceof InterestAccount).toList();
        for(Account account: interestAccounts){
            double d = AccountInterestService.Calculate((InterestAccount) account, period);
            AccountMovementService.deposit(account, d);
        }
    }
}

