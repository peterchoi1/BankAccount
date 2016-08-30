package ssa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.UUID;

public class Account {

    final int accountId; //local variable account ID for each object
    String description; //local variable account ID for each object
    double balance; //local variable account ID for each object
    DecimalFormat df = new DecimalFormat("$0.00"); //decimal format used for each $ amount
    ArrayList<String> accountBalanceChanges = new ArrayList<String>(); //holds all past transactions for each object

    //constructor for setting each object's account ID and also adding the initial balance to the arraylist
    public Account(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        System.out.println("New account has been created.\nAccount ID: " + this.accountId + "\nInitial Balance: " + df.format(this.balance));
        System.out.println(
                "\n***********************************************************************************************\n");
        accountBalanceChanges.add("Starting Balance: " + df.format(getBalance()));
    }

    
    //uses the checkTransfer method to see if transferring is possible with ">=0" constraints.
    //if transferring is possible, attaches a unique transaction id and transfers the $ amount from each account
    //adds the transaction to the arraylist
    void transferBalance(double transferAmount, Account toAccount) {
        String uniqueID = UUID.randomUUID().toString();
        if (checkTransfer(transferAmount) == (true)) {
            System.out.println("Transfering " + df.format(transferAmount) + " From - \"" + getDescription() + "\" to \""
                    + toAccount.getDescription() + "\"");
            this.balance -= transferAmount;
            toAccount.balance += transferAmount;
            System.out.println("Transaction ID: " + uniqueID + "\n");

            accountBalanceChanges.add("Balance: " + df.format(getBalance()) + " (Transferred -"
                    + df.format(transferAmount) + ") | Transaction ID: " + uniqueID);

            toAccount.accountBalanceChanges.add("Balance: " + df.format(toAccount.getBalance()) + " (Transferred +"
                    + df.format(transferAmount) + ") | Transaction ID: " + uniqueID);

        } else {
            System.out.println("Transfering " + df.format(transferAmount) + " From - \"" + getDescription() + "\" to \""
                    + toAccount.getDescription() + "\" was canceled. Insufficient Funds!\n");
        }

        accountStatus();
        System.out.println();
        toAccount.accountStatus();
        System.out.println(
                "\n***********************************************************************************************\n");

    }

    //prints out the user's account status such as ID and balance
    void accountStatus() {
        System.out.println("User's Account ID : " + getAccountId() + "\nDescription: " + getDescription()
                + "\nBalance: " + df.format(getBalance()));
    }

    //sets the account ID
    /*
    void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    */

    //returns the account ID
    int getAccountId() {
        return this.accountId;
    }

    //setting the account description
    void setDescription(String description) {
        this.description = description;
    }

    //returns the description
    String getDescription() {
        return this.description;
    }

    //setting the initial balance
    void setInitialBalance(double balance) {
        this.balance = balance;
    }

    //returns the balance
    double getBalance() {
        return this.balance;
    }

    //check if withdrawing the amount is possible from the account
    //if possible withdraw the amount and add it to the array list for past transactions
    //if impossible then println a message saying so
    void withdraw(double withdrawAmount) {

        String uniqueID = UUID.randomUUID().toString();
        if (this.balance - withdrawAmount >= 0) {
            this.balance -= withdrawAmount;
            System.out.println("Withdrawing... " + df.format(withdrawAmount));
            System.out.println("Transaction ID: " + uniqueID);
            accountBalanceChanges.add("Balance: " + df.format(getBalance()) + " (Withdrew -" + df.format(withdrawAmount)
                    + ") | Transaction ID: " + uniqueID);

        } else {
            System.out.println("Withdrawing... " + df.format(withdrawAmount));
            System.out.println("Insufficient Funds! Unable to withdraw " + df.format(withdrawAmount));

        }

        accountStatus();
        System.out.println(
                "\n***********************************************************************************************\n");

    }

    
    //check if transferring is possible as a utility for the transferBalance() method
    boolean checkTransfer(double transferAmount) {

        if (this.balance - transferAmount >= 0) {
            return true;
        } else {
            return false;
        }

    }

    
    //deposit the desired amount to the account and add the transaction to the array list
    void deposit(double depositAmount) {

        String uniqueID = UUID.randomUUID().toString();
        System.out.println("Depositing... " + df.format(depositAmount));
        System.out.println("Transaction ID: " + uniqueID);
        this.balance += depositAmount;
        accountBalanceChanges.add("Balance: " + df.format(getBalance()) + " (Deposited +" + df.format(depositAmount)
                + ") | Transaction ID: " + uniqueID);
        accountStatus();
        System.out.println(
                "\n***********************************************************************************************\n");

    }

    //loop through the array list and display all of the past transactions
    void checkBalanceHistory() {

        System.out.println(this.description + " past transactions");

        for (String recordedActions : accountBalanceChanges) {
            System.out.println(recordedActions.toString());
        }
        System.out.println("");
    }

}