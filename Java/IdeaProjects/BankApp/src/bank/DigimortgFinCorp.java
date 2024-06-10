package bank;

import java.util.Scanner;
public class DigimortgFinCorp 
{
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        Operations newops = new Operations();
        newops.transactionProgram();
    }
}
