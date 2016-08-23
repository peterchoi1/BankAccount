package ssa;

public class Mainline {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /*
        Account checking1 = new Account();
        checking1.setDescription("My personal checking account");
        checking1.balance = 800.00;
        checking1.print();
        checking1.deposit(300.00);
        checking1.print();
        checking1.withdraw(699.99);
        checking1.print();
        checking1.deposit(149.99);
        checking1.print();
        checking1.withdraw(950.00); // this should fail!
        checking1.print();
        checking1.withdraw(200.00);
        checking1.print(); // balance should be 350
        //
        Account savings1 = new Account("My personal savings account");
        savings1.deposit(1000.00);
        savings1.print();
        savings1.deposit(400.00);
        savings1.print();
        savings1.withdraw(750.00);
        savings1.print();
        savings1.withdraw(250.00);
        savings1.print();
        savings1.deposit(650.00);
        savings1.print(); // balance should be 1050.00
        // the transfer
        checking1.transferFrom(savings1, 100.00); // transfer 100 from savings to checking
        
        // another account
        Account checking2 = new Account("My slush fund checking account");
        checking2.deposit(300.00);
        checking2.print();
        checking2.withdraw(150.00);
        checking2.print();
        checking2.deposit(250.00);
        checking2.print();

        // more to come. Will be updated during the lab...*

        // print out all account balances
        checking1.print();
        checking2.print();
        savings1.print();
        */
        
     // create checking1 - default constructor
        Account checking1 = new Account();
//              checking1.id = 10;
//              checking1.balance = 1.00;
        int checking1Id = checking1.getId();
        System.out.println(checking1Id);
        checking1.setDescription("Checking 1");
        checking1.withdraw(100.00); // bal 0
        checking1.deposit(500.00); // bal 500
        checking1.deposit(200.00); // bal 700
        checking1.setDescription("Checking 1 Modified");
        checking1.deposit(200.00); // bal 900
        checking1.withdraw(900); // bal 0
        checking1.deposit(1.03); // bal 1.00

        // create checking2 - description constructor
        Account checking2 = new Account("Checking 2");
//              checking2.id = 20;
//              checking2.balance = 2.00;
        int checking2Id = checking2.getId();
        System.out.println(checking2Id);
        checking2.setDescription("Checking 1");
        checking2.withdraw(100.00); // bal 0
        checking2.deposit(500.00); // bal 500
        checking2.deposit(200.00); // bal 700
        checking2.setDescription("Checking 1 Modified");
        checking2.deposit(200.00); // bal 900
        checking2.withdraw(900.00); // bal 0
        checking2.deposit(2.02); // bal 2.02

        // create savings3 - description constructor
        Account savings3 = new Account("Savings 3");
//              savings3.id = 20;
//              savings3.balance = 2.00;
        int savings3Id = savings3.getId();
        System.out.println(savings3Id);
        savings3.setDescription("Checking 1");
        savings3.withdraw(100.00); // bal 0
        savings3.deposit(300.00); // bal 300
        savings3.deposit(200.00); // bal 500
        savings3.setDescription("Checking 1 Modified");
        savings3.deposit(100.00); // bal 600
        savings3.withdraw(600.00); // bal 0
        savings3.deposit(3.01); // bal 3.01

        // total should be 6.06;
        System.out.printf("Total all accounts is %.2f\n", checking1.getBalance() + checking2.getBalance() + savings3.getBalance());

        System.out.println("Transfer amount all accounts ...");
        checking1.transferFrom(checking2, 1.01);
        checking2.transferFrom(savings3, 1.01);
        savings3.transferFrom(checking1, 1.01);

        // total should be 6.06;
        System.out.printf("Total all accounts is %.2f\n", checking1.getBalance() + checking2.getBalance() + savings3.getBalance());

        

   }

}
