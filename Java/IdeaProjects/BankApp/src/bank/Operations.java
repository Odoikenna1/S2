package bank;

import java.util.Scanner;

public class Operations
{
    private Bank bank = new Bank();
    private Scanner scanner = new Scanner(System.in);

    public String displayPrompt(){
        String transactionPrompt = """
                \nWelcome to Digimortg FinCorp.

                1 -> Create account     2 -> Deposit funds
                3 -> Check Balance      4 -> Withdraw funds
                5 -> Transfer funds     6 -> Close account
                """;
                return transactionPrompt;
    }



    public void transactionProgram()
    {
         System.out.println(displayPrompt());
        String userInput = input("Enter an option: ");

            switch(userInput)
            {
                case "1":
                    String customerName = input("What is your name? ");
                    String bvnNumber = input("Enter your bvn number: ");
                    String pin = input("Create a secret pin: ");
                    MaintainAccounts newAccount = bank.createAccount(customerName, bvnNumber, pin);
                    System.out.println(newAccount.getAccountNumber());

                    transactionProgram();

                case "2":
                    String accountNumber = input("Enter your account number: ");
                    System.out.print(bank.getAccount(accountNumber)); 
                    transactionProgram();



            }
    }

    public String input(String textPrompt)
    {
        System.out.printf(textPrompt, " ");
        String stringInput = scanner.nextLine();
        return stringInput;
    }


}