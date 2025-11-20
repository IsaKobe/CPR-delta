package cz.richard.accounts.Helpers;

import cz.richard.accounts.Data.Accounts.Account;
import cz.richard.accounts.Data.Other.TransactionType;
import cz.richard.accounts.Helpers.History.TransactionFactory;
import cz.richard.accounts.Logger;

public class AccountMovementService {
    public static void withdraw(Account account, double amount) {
        if(AccountValidatorService.validateWithdraw(account.getBalance(), amount)) {
            double newBalance = account.getBalance() - amount;
            doMove(account, amount, newBalance, TransactionType.Withdraw);
        }
    }
    public static void deposit(Account account, double amount) {
        if(AccountValidatorService.validateDeposit(account.getBalance(), amount)){
            double newBalance = account.getBalance() + amount;
            doMove(account, amount, newBalance, TransactionType.Deposit);
        }
    }
    public  static void interest(Account account, double amount) {
        if(AccountValidatorService.validateDeposit(account.getBalance(), amount)){
            double newBalance = account.getBalance() + amount;
            doMove(account, amount, newBalance, TransactionType.Interest);
        }
    }

    static void doMove(Account account, double amount, double newBalance, TransactionType type) {
        Logger.logAction(account, amount, type);
        TransactionFactory.createTransaction(account, amount, type);
        account.setBalance(newBalance);
    }
}
