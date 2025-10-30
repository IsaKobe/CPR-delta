package cz.richard.accounts.Data;

import cz.richard.clients.Client;

import java.time.LocalDateTime;
import java.util.Date;

public class InterestAccount extends Account {
    double interest;

    LocalDateTime lastInterestDate;

    public InterestAccount(String id, String bankAccountNum, Client linkedClient, double balance, double interest) {
        super(id, bankAccountNum, linkedClient, balance);
        this.interest = interest;
        markInterest();
    }

    public double getInterest() {
        return interest;
    }

    public LocalDateTime  getLastInterestDate() {
        return lastInterestDate;
    }
    public void markInterest() {
        lastInterestDate = LocalDateTime.now();
    }
}
