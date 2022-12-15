package Account;

import Transaction.TransactionAssociated;
import Database.Model;
import Transaction.Transaction;
import Transaction.TransactionDatabase;
import User.User;

import java.util.ArrayList;

public abstract class Account implements Model, TransactionAssociated {
    private User user;
    private int accountNumber;
    private AccountType accountType;
    private double bal;

    public Account(User user, int accountNumber, AccountType accountType){
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.bal = 0;
    }
    public Account(User user, double bal, int accountNumber, AccountType accountType){
        this.user = user;
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

    public User getUser() {
        return user;
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
