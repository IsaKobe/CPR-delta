package cz.richard.accounts.Helpers;

import com.google.inject.Inject;
import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.InterestAccount;

import java.time.Duration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Account> interestAccounts = manager.accounts.stream().filter(account -> account instanceof InterestAccount).toList();
        for(Account account: interestAccounts){
            double d = AccountInterestService.Calculate((InterestAccount) account, period);
            AccountMovementService.deposit(account, d);
        }
        nextInterest = LocalDateTime.now().plus(period);
    }
}
