package cz.richard;

import cz.richard.accounts.AccountsFactory;
import cz.richard.accounts.Data.Account;
import cz.richard.accounts.Data.StudentAccount;
import cz.richard.accounts.Helpers.AccountHelperMovement;
import cz.richard.accounts.serialization.AccountData;
import cz.richard.accounts.serialization.Serializer;
import cz.richard.clients.Client;

/**
 * Main class
 */
public class Main {
    /**
     * entrypoint
     *
     * @param args cmd args
     */
    public static void main(String[] args) {
        System.out.println("Hello World");

        Client client = new Client("", "John", "Doe" );
        Account account = AccountsFactory.createAccount(client, 100);

        System.out.println(account.getBalance());
        System.out.println(account.getBankAccountNum());
        AccountHelperMovement.deposit(account, 100000);

        System.out.println(account.getBalance());
        AccountHelperMovement.withdraw(account, 75);

        System.out.println(account.getBalance());

        Account studentAccount = AccountsFactory.createStudentAccount(client, 50, "Delta");
        System.out.println(studentAccount instanceof StudentAccount ? "Student Account" : "Other Account");

        Serializer serializer = new Serializer();
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
}
