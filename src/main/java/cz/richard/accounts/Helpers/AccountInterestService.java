package cz.richard.accounts.Helpers;

import cz.richard.accounts.Data.InterestAccount;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public class AccountInterestService {
    public static double Calculate(InterestAccount interestAccount, Duration period) {
        double d = interestAccount.getBalance();
        double interest = interestAccount.getInterest();

        /*LocalDateTime dateTime = LocalDateTime.now();
        Duration a = Duration.between(interestAccount.getLastInterestDate(), dateTime);
        Duration b = Duration.between(interestAccount.getLastInterestDate(), interestAccount.getLastInterestDate().plus(period));
        interestAccount.markInterest();*/
        return d * (interest);// * (a.toSeconds() / (float)b.toSeconds()));
    }
}
