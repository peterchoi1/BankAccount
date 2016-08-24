package ssa;

public class Mainline {

    public static void main(String[] args) {

        Savings savings1 = new Savings();

        // testing constructor
        Savings savings2 = new Savings("Personal Savings Account2");

        // testing constructor that will check for duplicate ID's and
        // automatically generate an unused ID
        Savings savings3 = new Savings(1, "Personal Savings Account3");

        savings1.deposit(500);
        savings1.setMinimumBalance(500);
        savings1.setInterestRate(0.015);
        savings1.calcDepositInterest(4);
        savings1.calcDepositInterest(4);
        savings1.calcDepositInterest(4);
        savings1.calcDepositInterest(4);

        System.out.println(savings1.print());
        System.out.println(savings2.print());
        System.out.println(savings3.print());

    }

}
