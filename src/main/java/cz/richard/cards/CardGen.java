package cz.richard.cards;

import cz.richard.accounts.Data.Account;

import java.util.Random;

public class CardGen {
    Random rand;

    static CardGen instance = null;
    CardGen(){
        rand =  new Random();
    }
    public CardGen getInstance() {
        if(instance == null)
            instance = new CardGen();
        return instance;
    }

    public int CreateCVC(){
        return rand.nextInt(1000);
    }

    public long CreateCardNumber(){
        return rand.nextLong(10000000000000000L);
    }
}
