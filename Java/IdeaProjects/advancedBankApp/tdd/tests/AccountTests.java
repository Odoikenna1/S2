package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTests {
//    @BeforeEach
//    void setUp()
//    {
//        Bank gtBank = new Bank();
//    }
    @Test
    void test_deposit_In_class_account()
    {
        Account newCustomer = new Account("Abel", 123456789,"1234");
        newCustomer.deposit(500);
        assertEquals(500, newCustomer.checkBalance());
    }
    @Test
    void test_deposit_can_add_to_initial_deposit()
    {
        Account newCustomer = new Account("Abel", 123456789,"1234");
        newCustomer.deposit(500);
        assertEquals(500, newCustomer.checkBalance());
        newCustomer.deposit(500);
        assertEquals(1000, newCustomer.checkBalance());
    }
    @Test
    void test_deposit_cannot_add_negative_balance_to_accountBalance()
    {
        Account newCustomer = new Account("Abel", 123456789,"1234");
        newCustomer.deposit(500);
        assertEquals(500, newCustomer.checkBalance());
        newCustomer.deposit(-200);
        assertEquals(500, newCustomer.checkBalance());
    }
    @Test
    void test_withdraw_from_account_works()
    {
        Account newCustomer = new Account("Abel", 123456789,"1234");
        newCustomer.deposit(500);
        assertEquals(500, newCustomer.checkBalance());
        newCustomer.withdraw(200);
        assertEquals(300, newCustomer.checkBalance());
    }
    @Test
    void test_withdraw_cannot_deduct_negative_amount()
    {
        Account newCustomer = new Account("Abel", 123456789,"1234");
        newCustomer.deposit(500);
        assertEquals(500, newCustomer.checkBalance());
        newCustomer.withdraw(-100);
        assertEquals(500, newCustomer.checkBalance());
    }
    @Test
    void test_withdraw_cannot_deduct_amount_higher_than_balance()
    {
        Bank gtBank = new Bank();
        Account newCustomer = new Account("Abel", 123456789, "87");
        newCustomer.deposit(500);
        assertEquals(500, newCustomer.checkBalance());
        newCustomer.withdraw(600);
        assertEquals(500, newCustomer.checkBalance());
    }
    @Test
    void test_that_account_can_be_found_and_returned()
    {
        Bank gtBank = new Bank();
        gtBank.addCustomerAccount("jane", "1234");
        gtBank.addCustomerAccount("aj", "1233");
        Account foundAccount1 = gtBank.size().getFirst();
        Account foundAccount2 = gtBank.size().get(1);
        System.out.println(foundAccount1 + "\n" + foundAccount2);
        assertEquals("jane", foundAccount1.getName());
    }
    @Test
     void test_that_Bank_deposit_works()
    {
        Bank gtBank = new Bank();
        gtBank.addCustomerAccount("john", "1234");
        gtBank.depositTo(20_100_200_300L, 5000);
        assertEquals(5000, gtBank.checkBalanceFor(20_100_200_300L));
    }
    @Test
    void test_that_Bank_withdraw_works()
    {
        Bank gtBank = new Bank();
        gtBank.addCustomerAccount("john", "1234");
        gtBank.depositTo(20_100_200_300L, 5000);
        assertEquals(5000, gtBank.checkBalanceFor(20_100_200_300L));
        gtBank.withdrawFrom(20_100_200_300L, 2000);
        assertEquals(3000, gtBank.checkBalanceFor(20_100_200_300L));
    }
    @Test
    void test_that_Bank_can_transfer()
    {
        Bank gtBank = new Bank();
        gtBank.addCustomerAccount("john", "1234");
        gtBank.addCustomerAccount("Jane", "1234");
        gtBank.depositTo(20_100_200_300L, 10_000);
        assertEquals(10_000, gtBank.checkBalanceFor(20_100_200_300L));
        gtBank.transferFunds(20_100_200_300L, 3000, 20_100_200_301L);
        Account accountFound = gtBank.size().getFirst();
        Account accountFound2 = gtBank.size().get(1);
        System.out.println(accountFound + "\n" + accountFound2);
        assertEquals(7000, gtBank.checkBalanceFor(20_100_200_300L));
        assertEquals(3000, gtBank.checkBalanceFor(20_100_200_301L));
    }
}