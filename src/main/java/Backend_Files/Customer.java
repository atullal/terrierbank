package Backend_Files;

import Account.Account;
import Account.AccountFactory;
import Account.AccountType;
import Account.AccountDatabase;
import Loan.Loan;
import Loan.LoanDatabase;
import User.User;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    ArrayList<Account> accounts;
    ArrayList<Loan> loans;
    public Customer(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(name, dateOfBirth, address, idNumber, userName, password);
        this.accounts = new ArrayList<Account>();
        this.loans = new ArrayList<>();
    }

    public Customer(int id, String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(id, name, dateOfBirth, address, idNumber, userName, password);
        this.accounts = new ArrayList<Account>();
        this.loans = new ArrayList<>();
    }

    public void createAccount(int accountNo, AccountType accountType, int bal, String savingsAccNo){
        // TODO Add
        AccountFactory accountFactory = new AccountFactory();
        Account account;

        switch (accountType) {
            case SAVINGS:
            case CHECKING:
                account = accountFactory.makeAccount(this, accountType, bal, accountNo);
                account.save();
//                System.out.println(account);
                accounts.add(account);
                break;
            case SECURITY:
                account = accountFactory.makeSecurityAccount(this, savingsAccNo, bal, accountNo);
                account.save();
//                System.out.println(account);
                accounts.add(account);
                break;
        }

//        else {
//            // TODO Make security account with savings account no
//            account = accountFactory.makeAccount(type, bal, accountNo);
//            System.out.println("Security: "+accountNo);
//        }
        // TODO Add account to DB
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public void fetchLoans() {
        ArrayList<Loan> fetchedLoans = LoanDatabase.getLoans(this);
        if(fetchedLoans != null) {
            this.loans = fetchedLoans;
        }
    }

    public void fetchAccounts() {
        ArrayList<Account> fetchedAccounts = AccountDatabase.getAccounts(this);
        if(fetchedAccounts != null) {
            this.accounts = fetchedAccounts;
        }
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Account> getCheckingAccounts() {
        ArrayList<Account> checkingAccounts = new ArrayList<>();
        for (Account account :
                this.accounts) {
            if (account.getAccountType() == AccountType.CHECKING) {
                checkingAccounts.add(account);
            }
        }
        return checkingAccounts;
    }

    public ArrayList<Account> getSavingAccounts() {
        ArrayList<Account> savingAccounts = new ArrayList<>();
        for (Account account :
                this.accounts) {
            if (account.getAccountType() == AccountType.SAVINGS) {
                savingAccounts.add(account);
            }
        }
        return savingAccounts;
    }

    @Override
    public String toString() {
        return this.getUserName();
    }
}
