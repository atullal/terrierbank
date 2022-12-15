package Account;

import Backend_Files.Customer;
import Transaction.TransactionAssociated;
import Database.Model;
import Transaction.Transaction;
import Transaction.TransactionDatabase;

import java.util.ArrayList;

public abstract class Account implements Model, TransactionAssociated {
    private Customer customer;
    private int accountNumber;
    private AccountType accountType;
    private double bal;

    public Account(Customer customer, int accountNumber, AccountType accountType){
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.bal = 0;
    }
    public Account(Customer customer, double bal, int accountNumber, AccountType accountType){
        this.customer = customer;
        this.bal = bal;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }
    public double getAmount() {

        return bal;
    }

    @Override
    public void save() {
        AccountDatabase.insert(this);
    }

    @Override
    public String toString() {
        return String.valueOf(getAccountNumber());
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    @Override
    public void update() {
        AccountDatabase.update(this);
    }


    @Override
    public ArrayList<Transaction> getTransactions() {
        return TransactionDatabase.getTransactions(this);
    }
}
