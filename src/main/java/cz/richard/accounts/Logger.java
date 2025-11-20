package cz.richard.accounts;

import cz.richard.accounts.Data.Accounts.Account;
import cz.richard.accounts.Data.Other.TransactionType;

public class Logger {

    static void logDeposit(Account account, double amount) {
        log(String.format("deposit with account: %s, amount: %f", account, amount));
    }

    static void logWithdraw(Account account, double amount) {
        log(String.format("withdraw with account: %s, amount: %f", account, amount));
    }

    static void logInterest(Account account, double amount) {
        log(String.format("interest: %f added to account: %s", amount, account));
    }

    static void log(String message) {
        System.out.printf("%s: %s\n", java.time.LocalDateTime.now().getSecond(), message);
    }

    public static void logAction(Account account, double amount, TransactionType transactionType) {
        switch (transactionType) {
            case Deposit:
                logDeposit(account, amount);
                break;
            case Withdraw:
                logWithdraw(account, amount);
                break;
            case Interest:
                logInterest(account, amount);
                break;
        }
    }
}
