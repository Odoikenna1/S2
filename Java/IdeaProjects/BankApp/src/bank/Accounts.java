package bank;

public class Accounts
{

    private String customerName;
    protected String accountNumber;
    protected String bvnNumber;
    protected double accountBalance;
    private String pin;


    public Accounts(String customerName, String accountNumber, String bvnNumber, double accountBalance, String pin)
    {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.bvnNumber = bvnNumber;
        this.accountBalance = accountBalance;
        this.pin = pin;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public void updatePin(String pin)
    {
        this.pin = pin;
    }
    public void setBvnNumber(String bvnNumber)
    {
        this.bvnNumber = bvnNumber;
    }
    public String getBvnNumber()
    {
        return bvnNumber;
    }
    public String toString() {
        return "Accounts{" +
                "customerName='" + this.customerName + '\'' +
                ", accountNumber='" + this.accountNumber + '\'' +
                ", bvnNumber='" + this.bvnNumber + '\'' +
                ", accountBalance=" + this.accountBalance +
                ", pin='" + this.pin + '\'' +
                '}';
    }
    /*
     * There must be a means of control in your get method in order to restrict access (validation)  to the private fields of the object.
     */
}