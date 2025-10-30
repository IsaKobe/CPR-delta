package cz.richard.cards;

import com.google.inject.Inject;
import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.CardAccount;

import java.util.ArrayList;
import java.util.List;
public class CardManager {
    @Inject
    CardFactory cardFactory;

    List<Card> cards;
    public CardManager() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card addCard(CardAccount account) {
        Card card = cardFactory.createCard(account);
        cards.add(card);
        return card;
    }

    public List<Card> getCards(Account account) {
        return  cards;
        //return cards.stream().filter(card -> card.account == account).collect(Collectors.toList())
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public Card getCard(long cardNumber) {
        return cards.stream().filter(card -> card.number == cardNumber).findFirst().orElse(null);
    }

//    public Card getCard(Account account) {
//        return cards.stream().filter(card -> card.account == account).findFirst().orElse(null);
//    }
}
