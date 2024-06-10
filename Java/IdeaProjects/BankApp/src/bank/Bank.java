package bank;

import java.util.HashMap;
import java.security.SecureRandom;

public class Bank
{
    private static HashMap<String, MaintainAccounts> customerAccounts = new HashMap<>();
    private static SecureRandom generateAccountNumber = new SecureRandom();
    private static String accountNumberToString;



    public String generateAccountNumber()
    {
        long accountNumber = generateAccountNumber.nextLong(10_000_000_000L,90_000_000_000L);
        accountNumberToString = String.valueOf(accountNumber);
        return accountNumberToString;
    }
    public MaintainAccounts createAccount(String customerName, String bvnNumber, String pin)
    {
        String accountNumber = generateAccountNumber();
        display("Initializing account >>>>> \nAccount created successfully.");
        MaintainAccounts newAccount = new MaintainAccounts(customerName, accountNumber, bvnNumber, 0, pin);
        customerAccounts.put(accountNumber, newAccount);
        return newAccount;
    }
    public void getAccounts()
    {
        for (Accounts customerAccount : customerAccounts.values())
        {
            System.out.println(customerAccount); 
        }
    }
    public static void display(String message)
    {
        System.out.println(message);
    }
    public MaintainAccounts getAccount(String accountNumber)
    {
        if (customerAccounts.containsKey(accountNumber))
        {
            MaintainAccounts accountFound = customerAccounts.get(accountNumber);
            return accountFound;
        }
        return null;
    }
}