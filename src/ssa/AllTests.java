package ssa;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllTests {

    @Test
    public void test() {
        Account account1 = new Account();
        Account account2 = new Account();
        Savings savings1 = new Savings();
        Savings savings2 = new Savings();

        // all accounts should test for $0.00 balance
        assertEquals(0.00, account1.getBalance(), 0);
        assertEquals(0.00, account2.getBalance(), 0);
        assertEquals(0.00, savings1.getBalance(), 0);
        assertEquals(0.00, savings2.getBalance(), 0);

        // account1 should have a balance of $100.00 after depositing $100.00
        account1.deposit(100.00);
        assertEquals(100.00, account1.getBalance(), 0);

        // account 1 should have a balance of $50.00 after depositing $50.00
        account1.withdraw(50.00);
        assertEquals(50.00, account1.getBalance(), 0);

        //account 1 is transferring $10.00 to account 2
        account1.transferFrom(account2, 10.00);
        assertEquals(40.00, account1.getBalance(), 0);
        assertEquals(10.00, account2.getBalance(), 0);

        //account 1 and account 2 balances should not be any different from before
        //the amount being transferred is not possible
        account1.transferFrom(account2, 10000000.00);
        assertEquals(40.00, account1.getBalance(), 0);
        assertEquals(10.00, account2.getBalance(), 0);

        //testing the automatic id being assigned to each account
        assertEquals(1, account1.getId());
        assertEquals(2, account2.getId());
        assertEquals(3, savings1.getId());
        assertEquals(4, savings2.getId());

        //testing the description
        account1.setDescription("This is account number 1.");
        assertEquals("This is account number 1.", account1.getDescription());

        //testing if the minimum balance, interest rate, and total interest earned
        savings1.deposit(10000.00);
        assertEquals(0, savings1.getMinimumBalance(), 0);
        savings1.setMinimumBalance(100.00);
        assertEquals(100, savings1.getMinimumBalance(), 0);
        savings1.setInterestRate(0.01);
        savings1.calcDepositInterest(12);
        assertEquals(0.01, savings1.getInterestRate(), 0);
        assertEquals(100, savings1.getTotalInterestEarned(), 0);

        //testing that no interest is earned due to being under minimum balance
        savings2.deposit(100.00);
        savings2.setMinimumBalance(500.00);
        savings2.setInterestRate(0.5);
        savings2.calcDepositInterest(12);
        assertEquals(100, savings2.getBalance(), 0);
        assertEquals(0, savings2.getTotalInterestEarned(), 0);
    }

}
