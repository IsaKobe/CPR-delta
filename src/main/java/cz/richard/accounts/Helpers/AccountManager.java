package cz.richard.accounts.Helpers;

import cz.richard.accounts.AccountsFactory;
import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.CardAccount;
import cz.richard.cards.Card;
import cz.richard.clients.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountManager {
    static AccountsFactory accountFactory = new AccountsFactory();

    List<Account> accounts;
    public AccountManager() {
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account addAccount(Client client, int balance) {
        Account account = accountFactory.createAccount(client, balance);
        accounts.add(account);
        return account;
    }
    public CardAccount addCardAccount(Client client, int balance) {
        CardAccount account = (CardAccount) accountFactory.createCardAccount(client, balance);
        accounts.add(account);
        return account;
    }

    public void removeAccount(AccountsFactory account) {
        accounts.remove(account);
    }

    public void depositWithCard(Card card, double amount) {
        Account account = getAccountByCard(card);
        if(account != null)
            AccountHelperMovement.deposit(account, amount);
        else
            System.out.println("Account not found");
    }
    public void withdrawWithCard(Card card, double amount) {
        Account account = getAccountByCard(card);
        if(account != null)
            AccountHelperMovement.withdraw(account, amount);
        else
            System.out.println("Account not found");
    }

    CardAccount getAccountByCard(Card card) {
        return (CardAccount) accounts.stream().filter(account -> account.getClass() == CardAccount.class && ((CardAccount)account).getCard() == card).findFirst().orElse(null);
    }
}
