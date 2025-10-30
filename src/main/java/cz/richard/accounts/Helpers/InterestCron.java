package cz.richard.accounts.Helpers;

import com.google.inject.Inject;
import cz.richard.accounts.AccountsFactory;

import java.util.TimerTask;

public class InterestCron {
    InterestFacade facade;


    public InterestCron(InterestFacade _facade) {
        facade = _facade;
        StartTimer();
    }

    public void StartTimer(){
        java.util.Timer t = new java.util.Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.printf("This will run every %d seconds\n", facade.period.toSeconds());
                facade.processAllInterest();
            }
        }, 2000, facade.getPeriod().toMillis());
    }
}
