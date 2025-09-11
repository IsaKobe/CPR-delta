package cz.richard.accounts;

import cz.richard.clients.Client;


public class Account {
    String id;
    String bankAccountNum;

    Client linkedClient;

    double balance;

    public Account(String id, String bankAccountNum, Client linkedClient, double balance) {
        this.id = id;
        this.bankAccountNum = bankAccountNum;
        this.linkedClient = linkedClient;
        this.balance = balance;
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

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount < 0)
            throw new RuntimeException("Insufficient Balance");
        else
            balance -= amount;
    }
}
