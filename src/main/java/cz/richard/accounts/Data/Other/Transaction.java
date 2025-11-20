package cz.richard.accounts.Data.Other;

import cz.richard.accounts.Data.Accounts.Account;

import java.time.LocalDateTime;



public class Transaction {
    //transient public Account target;
    public double amount;
    public LocalDateTime date;
    public TransactionType type;

    public Transaction(Account target, double amount, LocalDateTime date, TransactionType type) {
        //this.target = target;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
}
