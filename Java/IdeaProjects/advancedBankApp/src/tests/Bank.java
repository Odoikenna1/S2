package tests;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private long randomAcctNum = 20_100_200_300L;
    private Account customerAcct;
    private ArrayList<Account> lstOfAccounts = new ArrayList<>();
    private int numberOfAccounts;

    public void addCustomerAccount(String name,  String pin)
    {
        long acctNum = generateAccountNumber();
        customerAcct  = new Account(name, acctNum, pin);
        lstOfAccounts.add(customerAcct);
        numberOfAccounts++;
        System.out.printf("Congratulations %s Your account has been created successfully.\nYour account number is %d.%n%n", customerAcct.getName(), acctNum);
    }
    private long generateAccountNumber() {return randomAcctNum++;}
    public void depositTo(long accountNumber, double amount)
    {
        customerAcct = findAccountWith(accountNumber);
        customerAcct.deposit(amount);
        System.out.println("Transaction successful.\n");

    }
    public void withdrawFrom(long accountNumber, double amount)
    {
        customerAcct = findAccountWith(accountNumber);
        customerAcct.withdraw(amount);
        System.out.println("Transaction successful.\n");
    }
    public void transferFunds(long senderAccountNumber, double amount, long receiverAccountNumber)
    {
        Account senderAccountNumberFound = findAccountWith(senderAccountNumber);
        Account receiverAccountNumberFound = findAccountWith(receiverAccountNumber);
        withdrawFrom(senderAccountNumber, amount);
        depositTo(receiverAccountNumber, amount);
        System.out.println("Transaction successful.\n");
    }
    public double checkBalanceFor(long accountNumber)
    {
        Account customerAcctNum = findAccountWith(accountNumber);
        double currentBal = customerAcctNum.checkBalance();
        return currentBal;
    }
    private Account findAccountWith(long accountNumber)
    {
        for(Account account : lstOfAccounts){if(account.getAccountNumber() == accountNumber){return account;}}
        return null;
    }
    public ArrayList<Account> size() {return lstOfAccounts;}
//    private void display(String message, Objects... args) {System.out.printf(message, args);}
}
