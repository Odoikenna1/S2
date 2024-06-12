package tests;

public class Account {

    private String name;
    private double accountBalance;
    private long accountNumber;
    private String pin;

    Account(String name, long accountNumber, String pin){
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;

    }
    public void deposit(double amount)
    {
        if (amount > 0) accountBalance += amount;
    }
    public void withdraw(double amount) {if(amount > 0 && accountBalance > amount) accountBalance -= amount;}
    public double checkBalance() {
        return accountBalance;
    }
    public long getAccountNumber(){ return this.accountNumber;}
    public String getName(){ return name;}
    @Override
    public String toString()
    {
        return String.format("""
                Account Name: %s,
                Account Number: %d,
                Account Balance: %.2f,
                Account Pin: %s
                """, getName(), getAccountNumber(), checkBalance(), this.pin);
    }
}
