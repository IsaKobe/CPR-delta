package cz.richard.accounts.Data;

import cz.richard.cards.Card;
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

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    @Override
    public String toString() {
        return "id: " + id + ", bankAccountNum: " + bankAccountNum + ", linkedClient: " + linkedClient;
    }
}
