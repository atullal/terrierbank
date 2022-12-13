package Backend_Files;

import Account.Account;
import Account.AccountFactory;
import Account.AccountType;
import User.User;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    ArrayList<Account> accounts;
    public Customer(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(name, dateOfBirth, address, idNumber, userName, password);
        this.accounts = new ArrayList<Account>();
    }

    public Customer(int id, String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(id, name, dateOfBirth, address, idNumber, userName, password);
        this.accounts = new ArrayList<Account>();
    }

    public void createAccount(String accountNo, AccountType accountType, int bal){
        // TODO Add
        AccountFactory accountFactory = new AccountFactory();
        Account account;

        switch (accountType) {
            case SAVINGS:
            case CHECKING:
                account = accountFactory.makeAccount(this, accountType, bal, accountNo);
                account.save();
                System.out.println(account);
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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
