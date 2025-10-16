package cz.richard.accounts.Helpers;

public class AccountHelperValidator {
    static AccountHelperValidator instance;

    private AccountHelperValidator(){}

    public static AccountHelperValidator getInstance() {
        if (instance == null) {
            instance = new AccountHelperValidator();
        }
        return instance;
    }

    public boolean validateDeposit(double balance, double amount) {
        if(amount <= 0)
            return false;
        if(amount > 10000)
        {
            System.err.println("Deposit bigger than 10000");
            return false;
        }

        return true;
    }

    public boolean validateWithdraw(double balance, double amount) {
        if(amount <= 0)
            return false;
        if(balance < amount)
            return false;

        return true;
    }
}
