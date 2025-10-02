package cz.richard.accounts;

import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.InterestAccount;
import cz.richard.accounts.Data.StudentAccount;
import cz.richard.clients.Client;

public class AccountsFactory {

    static AccountGen gen = new AccountGen();

    public static Account createAccount(Client client, double balance) {
        return new Account(gen.generateID(), gen.generateAccountNum(), client, balance);
    }

    public static Account createInterestAccount(Client client, double balance, double interestRate) {
        return new InterestAccount(gen.generateID(), gen.generateAccountNum(), client, balance, interestRate);
    }

    public static Account createStudentAccount(Client client, double balance, String schoolName) {
        return new StudentAccount(gen.generateID(), gen.generateAccountNum(), client, balance, schoolName);
    }
}
