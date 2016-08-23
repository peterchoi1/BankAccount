package ssa;

import java.text.DecimalFormat;
import java.util.ArrayList;
//import java.util.UUID;

public class Account {

    private int accountId; //local variable account ID for each object
    private String description; //local variable account ID for each object
    double balance; //local variable account ID for each object
    private DecimalFormat df = new DecimalFormat("$0.00"); //decimal format used for each $ amount
    //private ArrayList<String> accountBalanceChanges = new ArrayList<String>(); //holds all past transactions for each object
    private static ArrayList<Integer> accountIdList = new ArrayList<Integer>();
    private static int count = 1;

    
    public Account() {
        setAccountId(count);
        accountIdList.add(count);
        count++;
        
    }
    
    
    public Account(String description) {
        setAccountId(count);
        setDescription(description);
        accountIdList.add(count);
        count++;
    }
    
    public Account(int id, String description) {
       
        boolean duplicateFound = false;
        
      do { 
        if(accountIdList.contains(id)) {
            id++;
            duplicateFound = true;
        } else { 
            setAccountId(id);
            setDescription(description);
            accountIdList.add(id);
            duplicateFound = false;
        }
      } while(duplicateFound == true);
       
    }
    
    
    //uses the checkTransfer method to see if transferring is possible with ">=0" constraints.
    //if transferring is possible, attaches a unique transaction id and transfers the $ amount from each account
    //adds the transaction to the arraylist
    void transferFrom(Account toAccount, double transferAmount) {
        //String uniqueID = UUID.randomUUID().toString();
        if (checkTransfer(transferAmount) == (true)) {
          //  System.out.println("Transfering " + df.format(transferAmount) + " From - \"" + toAccount.getDescription() + "\" to \""
           //         + this.getDescription() + "\"");
            toAccount.balance -= transferAmount;
            this.balance += transferAmount;
           // System.out.println("Transaction ID: " + uniqueID);
           // System.out.println(
           //         "\n***********************************************************************************************\n");

        } else {
         //   System.out.println("Transfering " + df.format(transferAmount) + " From - \"" + toAccount.getDescription() + "\" to \""
          //          + this.getDescription() + "\" was canceled. Insufficient Funds!");
          //  System.out.println(
          //          "\n***********************************************************************************************\n");
        }

    }

    //prints out the user's account status such as ID and balance
    String print() {
        
        return "Account " + getAccountId() + " balance is " + df.format(getBalance()); 

        
//        System.out.println("User's Account ID : " + getAccountId() + "\nDescription: " + getDescription()
//                + "\nBalance: " + df.format(getBalance()));
//        System.out.println(
//                "\n***********************************************************************************************\n");

    
    }

    //sets the account ID
    private void setAccountId(int accountId) {
        this.accountId = accountId;
    }

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
    
    private void setBalance(double balance) {
        this.balance = balance;
    }

    //check if withdrawing the amount is possible from the account
    //if possible withdraw the amount and add it to the array list for past transactions
    //if impossible then println a message saying so
    void withdraw(double withdrawAmount) {

        //String uniqueID = UUID.randomUUID().toString();
        if (this.balance - withdrawAmount >= 0) {
            this.balance -= withdrawAmount;
           // System.out.println("Withdrawing... " + df.format(withdrawAmount));
          //  System.out.println("Transaction ID: " + uniqueID);

        } else {
           // System.out.println("Withdrawing... " + df.format(withdrawAmount));
          //  System.out.println("Insufficient Funds! Unable to withdraw " + df.format(withdrawAmount));

        }

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

        //String uniqueID = UUID.randomUUID().toString();
       // System.out.println("Depositing... " + df.format(depositAmount));
       // System.out.println("Transaction ID: " + uniqueID);
        this.balance += depositAmount;
        
    }

}