package Account;

import Backend_Files.Customer;
import Database.Model;

public abstract class Account implements Model {
    private Customer customer;
    private String accountNumber;
    private AccountType accountType;
    private double bal;

    public Account(Customer customer, String accountNumber, AccountType accountType){
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.bal = 0;
    }
    public Account(Customer customer, double bal, String accountNumber, AccountType accountType){
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
        return getAccountNumber();
    }

    public String getAccountNumber() {
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

    public void setAmount(double bal) {
        this.bal = bal;
    }
}
