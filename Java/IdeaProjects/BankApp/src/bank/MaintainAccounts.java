package bank;

public class MaintainAccounts extends Accounts
{   

    public MaintainAccounts(String customerName, String accountNumber, String bvnNumber, double accountBalance, String pin)
    {
        super(customerName, accountNumber, bvnNumber, accountBalance, pin);
    }

    public void depositFunds(double depositAmount)
    {
        if (depositAmount <= 0) throw new IllegalArgumentException("Transaction failed, check the amountand try again.");
        accountBalance += depositAmount;
    }
    public  void withdrawFunds(double withdrawAmount)
    {
        if (withdrawAmount > accountBalance) throw new IllegalArgumentException("Transaction failed, check the amountand try again.");
        accountBalance -= withdrawAmount;
    }

}
