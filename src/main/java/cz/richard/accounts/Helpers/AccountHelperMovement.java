package cz.richard.accounts.Helpers;

import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Logger;
import cz.richard.cards.Card;

public class AccountHelperMovement {
    public static void withdraw(Account account, double amount) {
        if(AccountHelperValidator.validateWithdraw(account.getBalance(), amount)) {
            Logger.getInstance().logWithdraw(account, amount);
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
    }
    public static void deposit(Account account, double amount) {
        if(AccountHelperValidator.validateDeposit(account.getBalance(), amount)){
            double newBalance = account.getBalance() + amount;
            Logger.getInstance().logDeposit(account, amount);
            account.setBalance(newBalance);
        }
    }
}
