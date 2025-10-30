package cz.richard.App;

import com.google.inject.Inject;
import cz.richard.accounts.AccountGen;
import cz.richard.accounts.AccountsFactory;
import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.CardAccount;
import cz.richard.accounts.Data.StudentAccount;
import cz.richard.accounts.Helpers.AccountMovementService;
import cz.richard.accounts.Helpers.AccountManager;
import cz.richard.accounts.serialization.AccountData;
import cz.richard.accounts.serialization.Serializer;
import cz.richard.cards.Card;
import cz.richard.cards.CardFactory;
import cz.richard.cards.CardGen;
import cz.richard.cards.CardManager;
import cz.richard.clients.Client;
import cz.richard.clients.ClientFactory;

public class App {

    //@Inject @Deprecated
    //Container container;

    @Inject
    private AccountsFactory accountsFactory;
    @Inject
    private AccountGen accountGen;

    @Inject
    private CardFactory cardFactory;
    @Inject
    private CardGen cardGen;

    @Inject
    private Serializer serializer;

    @Inject
    private CardManager cardManager;
    @Inject
    private AccountManager accountManager;

    @Inject
    private ClientFactory clientFactory;


    public void Run() {
        AccountTest();
        offset();
        SerializeTest();
        offset();
        CardTest();
    }

    private static void offset() {
        System.out.println("\n--------------\n");
    }

    void AccountTest() {

        Client client = clientFactory.CreateCustomer("John", "Doe");

        Account account = accountsFactory.createAccount(client, 100);

        System.out.println(account.getBalance());
        System.out.println(account.getBankAccountNum());
        AccountMovementService.deposit(account, 100000);

        System.out.println(account.getBalance());
        AccountMovementService.withdraw(account, 75);

        System.out.println(account.getBalance());

        Account studentAccount = accountsFactory.createStudentAccount(client, 50, "Delta");
        System.out.println(studentAccount instanceof StudentAccount ? "Student Account" : "Other Account");

    }

    void SerializeTest() {
        Client client = clientFactory.CreateCustomer("John", "Doe");

        Account account = accountsFactory.createAccount(client, 100);

        AccountData[] accounts = new AccountData[2];
        accounts[0] = new AccountData(account);
        accounts[1] = new AccountData(account);

        System.out.println(serializer.serialize(accounts));

        String ser = serializer.serialize(account);
        System.out.println(ser);
        Account account1 = (Account) serializer.deserialize(ser, Account.class);
        System.out.println(account1.getBalance());

        System.out.println(serializer.serializeXML(account1));
    }

    void CardTest() {
        Client client = clientFactory.CreateCustomer( "John", "Doe");
        CardAccount account = accountManager.addCardAccount(client, 100);
        Account acc = accountManager.addAccount(client, 100);

        Card card = cardManager.addCard(account);

        accountManager.withdrawWithCard(card, 75);
        System.out.println(account.getBalance());
        accountManager.depositWithCard(card, 200);
        System.out.println(account.getBalance());

        accountManager.getAccounts().forEach(System.out::println);
    }
}
