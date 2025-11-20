package cz.richard.accounts.Helpers.History;

import cz.richard.accounts.Data.Accounts.Account;
import cz.richard.accounts.Data.Accounts.InterestAccount;
import cz.richard.accounts.Data.Other.Transaction;
import cz.richard.accounts.Helpers.AccountInterestService;
import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.Helpers.AccountMovementService;
import cz.richard.accounts.serialization.Serializer;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryFacade implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        AccountManager manager = (AccountManager) map.get("accountManager");


        List<List<Transaction>> transactions = manager.getAccounts().stream().map(Account::getTransactions).toList();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("abc.txt", true) );
            String s = Serializer.serialize(transactions);
            System.out.println(s);
            writer.write(LocalDateTime.now().toString()+ "\n" + s + "\n");

            writer.close();
        } catch (Exception e) {
            System.err.println("Error while writing to file" + e.getMessage());
        }
    }
}
