package cz.richard.accounts;

import com.google.inject.Inject;
import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.CardAccount;
import cz.richard.accounts.Data.InterestAccount;
import cz.richard.accounts.Data.StudentAccount;
import cz.richard.clients.Client;

public class AccountsFactory {
    @Inject
    AccountGen gen;

    public AccountsFactory() {

    }

    public Account createAccount(Client client, double balance) {
        return new Account(gen.generateID(), gen.generateAccountNum(), client, balance);
    }

    public Account createInterestAccount(Client client, double balance, double interestRate) {
        return new InterestAccount(gen.generateID(), gen.generateAccountNum(), client, balance, interestRate);
    }

    public Account createStudentAccount(Client client, double balance, String schoolName) {
        return new StudentAccount(gen.generateID(), gen.generateAccountNum(), client, balance, schoolName);
    }

    public  Account createCardAccount(Client client, double balance) {
        return new CardAccount(gen.generateID(), gen.generateAccountNum(), client, balance);
    }
}
