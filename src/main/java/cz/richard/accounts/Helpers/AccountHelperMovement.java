package cz.richard.accounts.Helpers;

import cz.richard.accounts.Data.Account;
import cz.richard.cards.Card;

import javax.xml.validation.Validator;

public class AccountHelperMovement {
    AccountHelperValidator validator;


    static  AccountHelperMovement instance;
    AccountHelperMovement() {
        validator =  AccountHelperValidator.getInstance();
    }
    public static AccountHelperMovement getInstance() {
        if(instance == null)
            instance = new AccountHelperMovement();
        return instance;
    }

    public void withdraw(Account account, double amount) {
        if(AccountHelperValidator.getInstance().validateWithdraw(account.getBalance(), amount)) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
    }
    public void deposit(Account account, double amount) {
        if(AccountHelperValidator.getInstance().validateDeposit(account.getBalance(), amount)){
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
        }
    }
}
