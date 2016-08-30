package ssa;

public class Mainline {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Account checking = new Account(100, 500.00); //constructor for initial balance
        //checking.setAccountId(100); //setting account ID
        checking.setDescription("My personal checking account"); //setting account descriptions

        Account savings = new Account(200, 1000.00); //constructor for initial balance
        //savings.setAccountId(200);//setting account ID
        savings.setDescription("My personal savings account");//setting account descriptions

        checking.deposit(200.00);

        checking.withdraw(600.00);

        checking.deposit(100.00);

        checking.withdraw(300.00);

        checking.withdraw(200.00);

        savings.withdraw(750.00);

        savings.withdraw(250.00);

        savings.deposit(200.00);

        savings.transferBalance(100.00, checking); //transferring $100.00 from savings to checking

        checking.checkBalanceHistory(); //displays all past transactions for checking
        savings.checkBalanceHistory(); //displays all past transactions for savings

    }

}
