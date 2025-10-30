package cz.richard.accounts.Helpers;

public class AccountValidatorService {
    public static boolean validateDeposit(double balance, double amount) {
        if(amount <= 0)
            return false;
        if(amount > 10000)
        {
            System.err.println("Deposit bigger than 10000");
            return false;
        }

        return true;
    }

    public static boolean validateWithdraw(double balance, double amount) {
        if(amount <= 0)
            return false;
        if(balance < amount)
            return false;

        return true;
    }
}
