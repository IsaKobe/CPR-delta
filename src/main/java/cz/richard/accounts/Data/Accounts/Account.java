package cz.richard.accounts.Data.Accounts;

import cz.richard.accounts.Data.Other.Transaction;
import cz.richard.clients.Client;

import java.util.ArrayList;
import java.util.List;


public class Account {
    String id;
    String bankAccountNum;

    Client linkedClient;
    double balance;
    List<Transaction> transactions;

    public Account(String id, String bankAccountNum, Client linkedClient, double balance) {
        this.id = id;
        this.bankAccountNum = bankAccountNum;
        this.linkedClient = linkedClient;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getBankAccountNum() {
        return bankAccountNum;
    }

    public Client getLinkedClient() {
        return linkedClient;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {return transactions;}
    public void setBalance(double newBalance) {
        balance = newBalance;
    }


    @Override
    public String toString() {
        return "id: " + id + ", bankAccountNum: " + bankAccountNum + ", linkedClient: " + linkedClient;
    }

}
