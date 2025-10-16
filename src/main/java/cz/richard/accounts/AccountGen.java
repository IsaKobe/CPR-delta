package cz.richard.accounts;

import java.util.Random;

public class AccountGen {

    static AccountGen instance = null;
    public static AccountGen getInstance()
    {
        if(instance == null)
            instance = new AccountGen();
        return instance;
    }

    private AccountGen(){}

    public String generateAccountNum(){
        StringBuilder accountNum = new StringBuilder();
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            accountNum.append(rand.nextInt(10));
        }
        return accountNum.toString();
    }
    public String generateID(){
        StringBuilder id = new StringBuilder();
        Random rand = new Random();
        for(int i = 0; i < 25; i++){
            id.append((char) rand.nextInt(65,91));
        }
        return id.toString();
    }
}
