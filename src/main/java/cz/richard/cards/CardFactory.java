package cz.richard.cards;

import com.google.inject.Inject;
import cz.richard.accounts.Data.CardAccount;

import java.time.LocalDate;

public class CardFactory {
    @Inject
    CardGen cardGen;
    final int CARD_VALID_LENGTH_YEAR = 4;

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
