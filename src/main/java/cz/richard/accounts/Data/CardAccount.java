package cz.richard.accounts.Data;

import cz.richard.cards.Card;
import cz.richard.clients.Client;

/// Adds a card by which you can then find the account {@link cz.richard.accounts.Helpers.AccountManager}
public class CardAccount extends Account {

    /// Card assigned to this account
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
