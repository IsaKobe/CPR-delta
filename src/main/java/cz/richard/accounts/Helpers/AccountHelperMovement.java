package cz.richard.accounts.Helpers;

import cz.richard.accounts.Data.Account;

public class AccountHelperMovement {
    public static void withdraw(Account account, double amount) {
        if(AccountHelperValidator.validateWithdraw(account.getBalance(), amount)) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
    }
    public static void deposit(Account account, double amount) {
        if(AccountHelperValidator.validateDeposit(account.getBalance(), amount)){
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
        }
    }
}
