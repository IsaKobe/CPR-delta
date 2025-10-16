package cz.richard.cards;

import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.CardAccount;

import java.time.LocalDate;

public class CardFactory {
    CardGen cardGen;
    final int CARD_VALID_LENGTH_YEAR = 4;

    static CardFactory instance = null;
    private CardFactory() {
        cardGen = new CardGen();
    }
    public static CardFactory getInstance() {
        if(instance == null)
            instance = new CardFactory();
        return instance;
    }


    public Card createCard(CardAccount account) {
        Card card = new Card();
        card.number = cardGen.CreateCardNumber();
        card.CVC = cardGen.CreateCVC();
        LocalDate date = LocalDate.now();
        card.expireMonth = date.getMonthValue();
        card.expireYear = date.getYear() + CARD_VALID_LENGTH_YEAR;
        account.setCard(card);
        return card;
    }
}
