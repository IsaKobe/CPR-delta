package cz.richard.accounts.Data;

import cz.richard.cards.Card;
import cz.richard.clients.Client;

public class CardAccount extends Account {

    Card card = null;
    public CardAccount(String id, String bankAccountNum, Client linkedClient, double balance) {
        super(id, bankAccountNum, linkedClient, balance);
    }


    public void setCard(Card _card) {
        card = _card;
    }
    public Card getCard() {
        return card;
    }

    @Override
    public String toString() {
        return super.toString() + ", card: " + card;
    }
}
