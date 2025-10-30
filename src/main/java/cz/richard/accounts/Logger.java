package cz.richard.accounts;

import cz.richard.accounts.Data.Account;

import java.sql.Date;

public class Logger {
    static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void logDeposit(Account account, double amount) {
        log(String.format("deposit with account: %s, amount: %f", account, amount));
    }
    public void logWithdraw(Account account, double amount) {
        log(String.format("withdraw with account: %s, amount: %f", account, amount));
    }

    void log(String message) {
        System.out.printf("%s: %s\n", java.time.LocalDate.now(), message);
    }
}
