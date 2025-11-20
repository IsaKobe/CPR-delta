package cz.richard.accounts.Helpers.Timer;

import cz.richard.accounts.Data.Accounts.Account;
import cz.richard.accounts.Data.Accounts.InterestAccount;
import cz.richard.accounts.Helpers.AccountInterestService;
import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.Helpers.AccountMovementService;

import java.time.Duration;

import java.time.LocalDateTime;
import java.util.List;

public class InterestFacade {
    LocalDateTime nextInterest;
    final Duration period = Duration.ofSeconds(5);

    public Duration getPeriod() {
        return period;
    }

    AccountManager manager;

    public InterestFacade(AccountManager _manager) {
        manager = _manager;
    }


    void processAllInterest(){
        List<Account> interestAccounts = manager.getAccounts().stream().filter(account -> account instanceof InterestAccount).toList();
        for(Account account: interestAccounts){
            double d = AccountInterestService.Calculate((InterestAccount) account, period);
            AccountMovementService.interest(account, d);
        }
        nextInterest = LocalDateTime.now().plus(period);
    }
}
