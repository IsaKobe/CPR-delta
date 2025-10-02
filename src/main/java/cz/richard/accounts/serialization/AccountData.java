package cz.richard.accounts.serialization;

import cz.richard.accounts.Data.Account;

public class AccountData implements ISerializable {
    public String id;
    public String num;
    public double balance;
    public String ClientID;

    public AccountData(Object account) {
        Account a = (Account)account;
        id = a.getId();
        num = a.getBankAccountNum();
        balance = a.getBalance();
        ClientID = a.getLinkedClient().getId();
    }

    public AccountData(String json){
        String[] fields = json.split(",");
        id = fields[0];
        num = fields[1];
    }

    @Override
    public String serialize() {
        return String.
                format("""
                    "id": "%s",
                        "num": "%s",
                        "balance": "%s",
                        "client": "%s"
                """, id, num, balance, ClientID);
    }

}
