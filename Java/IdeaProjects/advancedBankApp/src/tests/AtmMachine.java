package tests;

import java.util.Scanner;

public class AtmMachine {
    private Bank gtBank = new Bank();

    public static void main(String[] args) {AtmMachine tellerX = new AtmMachine(); tellerX.gotoMainMenu();}
    private void gotoMainMenu()
    {
        display("""
                Welcome to DigiMortg FinTechnologies.
                Experience premium banking.
                1 -> Create account     2 -> Deposit funds
                3 -> Withdraw funds     4 -> Transfer funds
                5 -> Check balance      6 -> Exit
                """);
        String optionInput1 = input("Enter an option");
        char input = optionInput1.charAt(0);
        switch(input){
            case '1' -> createAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
            case '5' -> checkBalance();
            case '6' -> exitApplication();
        }
    }
    private void exitApplication() {
        System.exit(0);
    }
    private void checkBalance() {
        long accountNumber = Long.parseLong(input("Enter your account number: "));
        gtBank.checkBalanceFor(accountNumber);
        gotoMainMenu();
    }

    private void transfer() {
        long senderAccountNum = Long.parseLong(input("Enter your account number: "));
        double amount = Double.parseDouble(input("How much do you want to deposit: "));
        long recipientAccountNum =Long.parseLong(input("Enter recipient account number: "));
        gtBank.withdrawFrom(senderAccountNum, amount);
        gtBank.depositTo(recipientAccountNum, amount);
        gotoMainMenu();
    }
    private void withdraw() {
        long accountNum = Long.parseLong(input("Enter your account number: "));
        double amount = Double.parseDouble(input("How much do you want to deposit: "));
        gtBank.withdrawFrom(accountNum, amount);
        gotoMainMenu();
    }
    private void deposit() {
        long accountNum = Long.parseLong(input("Enter your account number: "));
        double amount = Double.parseDouble(input("How much would you like to deposit? "));
        gtBank.depositTo(accountNum, amount);
        gotoMainMenu();
    }
    private void createAccount() {
        String name = input("What is your name? ");
        String pin = input("Create a secret pin: ");
        gtBank.addCustomerAccount( name,  pin);
        Account acctDetails = gtBank.size().getFirst();
        gotoMainMenu();
    }
    private String input(String textPrompt)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textPrompt);
        return scanner.nextLine();
    }
    private void display(String message) {System.out.println(message);}

}