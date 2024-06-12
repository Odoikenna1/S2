package tests;

import java.util.ArrayList;

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
    }
    private long generateAccountNumber() {return randomAcctNum++;}
    public void depositTo(long accountNumber, double amount)
    {
        customerAcct = findAccountWith(accountNumber);
        customerAcct.deposit(amount);
    }
    public void withdrawFrom(long accountNumber, double amount)
    {
        customerAcct = findAccountWith(accountNumber);
        customerAcct.withdraw(amount);
    }
    public void transferFunds(long senderAccountNumber, double amount, long receiverAccountNumber)
    {
        Account senderAccountNumberFound = findAccountWith(senderAccountNumber);
        Account receiverAccountNumberFound = findAccountWith(receiverAccountNumber);
        withdrawFrom(senderAccountNumber, amount);
        depositTo(receiverAccountNumber, amount);
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
}
