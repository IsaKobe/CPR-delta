package cz.richard.accounts.Helpers.History;

import cz.richard.accounts.Data.Accounts.Account;
import cz.richard.accounts.Data.Other.Transaction;
import cz.richard.accounts.Data.Other.TransactionType;

import java.time.LocalDateTime;

public class TransactionFactory {
    public static Transaction createTransaction(Account account, double change, TransactionType type) {
        Transaction transaction = new Transaction(account, change, LocalDateTime.now(), type);
        account.getTransactions().add(transaction);
        return transaction;
    }
}
