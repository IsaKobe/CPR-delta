package cz.richard.accounts;

import cz.richard.clients.Client;

public class StudentAccount extends Account {
    String schoolName;

    public StudentAccount(String id, String bankAccountNum, Client linkedClient, double balance, String schoolName) {
        super(id, bankAccountNum, linkedClient, balance);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
