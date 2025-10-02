package cz.richard.accounts.Data;

import cz.richard.clients.Client;

public class InterestAccount extends Account {
    double interest;

    public InterestAccount(String id, String bankAccountNum, Client linkedClient, double balance, double interest) {
        super(id, bankAccountNum, linkedClient, balance);
        this.interest = interest;
    }

   public void AddInterest(){
        balance *= interest;
   }
   public double getInterest() {
       return balance * interest;
   }
}
