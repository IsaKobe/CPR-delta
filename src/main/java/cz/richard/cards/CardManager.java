package cz.richard.cards;

import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.CardAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/// One list of cards, can have multiple instances
public class CardManager {
    static CardFactory cardFactory;

    List<Card> cards;
    public CardManager() {
        cards = new ArrayList<>();
        cardFactory = CardFactory.getInstance();
    }

    public List<Card> getCards() {
        return cards;
    }


    public Card addCard(CardAccount account) {
        Card card = cardFactory.createCard(account);
        cards.add(card);
        return card;
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public Card getCard(long cardNumber) {
        return cards.stream().filter(card -> card.number == cardNumber).findFirst().orElse(null);
    }
}
