package cz.richard;

import cz.richard.accounts.Account;
import cz.richard.accounts.StudentAccount;
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
        Account account = new Account("", "123", client, 50);

        System.out.println(account.getBalance());
        account.deposit(500);

        System.out.println(account.getBalance());
        account.withdraw(600);

        System.out.println(account.getBalance());

        Account studentAccount = new StudentAccount("", "4560", client, 50, "Delta");
        System.out.println(studentAccount instanceof StudentAccount ? "Student Account" : "Other Account");
    }
}
