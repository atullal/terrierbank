package Account;

import Bank.BankManagerDatabase;
import Bank.Customer;
import Bank.CustomerDatabase;
import Database.DatabaseController;
import User.UserController;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDatabase {

    public static void createTable() {
        String statement = "CREATE TABLE ACCOUNT " +
                "(ACCOUNTNUM INTEGER PRIMARY KEY," +
                " USERID           INTEGER  NOT NULL, " +
                " ACCOUNTTYPE            TEXT     NOT NULL, " +
                " ASSOCIATEDACCNUM           INTEGER DEFAULT 0, " +
                " BALANCE        INTEGER NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static Account getAccountFromNumber(int accountNum) {

        Account account = null;
        String statement = "SELECT * FROM ACCOUNT WHERE ACCOUNTNUM="+accountNum+";";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            if (result.next()) {
                int  userId = result.getInt("USERID");
                Customer customer = null;
                if(UserController.getInstance().getLoggedInUser().getId() == userId) {
                    customer = (Customer) UserController.getInstance().getLoggedInUser();
                } else {
                    customer = CustomerDatabase.getCustomerUsingID(userId);
                    customer.fetchLoans();
                    customer.fetchAccounts();
                }
                String accounttype  = result.getString("ACCOUNTTYPE");
                AccountType type = AccountType.of(accounttype);
                int  balance = result.getInt("BALANCE");
                int associatedAccNum = result.getInt("ASSOCIATEDACCNUM");
                System.out.println(accountNum);

                AccountFactory accountFactory = new AccountFactory();
                switch (type) {
                    case CHECKING:
                    case SAVINGS:
                        account = accountFactory.makeAccount(customer, type, balance, accountNum);
                        break;
                    case SECURITY:
                        Account associatedAccount = null;
                        for (Account itAccount :
                                customer.getAccounts()) {
                            if (itAccount.getAccountNumber() == associatedAccNum) {
                                associatedAccount = account;
                            }
                        }

                        if(associatedAccount == null) {
                            account = new SecurityAccount(customer, accountNum, balance, associatedAccNum);
                        } else {
                            account = accountFactory.makeSecurityAccount(customer, associatedAccount, balance, accountNum);
                        }
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return account;
    }

    public static BankManagerAccount getBankManagerAccount() {
        BankManagerAccount account = null;
        String statement = "SELECT * FROM ACCOUNT WHERE ACCOUNTNUM=999999999;";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            if (result.next()) {
                int  userId = result.getInt("USERID");
                String accounttype  = result.getString("ACCOUNTTYPE");
                AccountType type = AccountType.of(accounttype);
                int  balance = result.getInt("BALANCE");

                account = new BankManagerAccount(BankManagerDatabase.getBankManager("admin", "12345"), balance, 999999999);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the account");
            System.out.println(e);
        }
        return account;
    }


    public static ArrayList<Account> getAccounts(Customer customer) {
        String statement = "SELECT * FROM ACCOUNT WHERE USERID="+customer.getId()+";";
        System.out.println(statement);
        ArrayList<Account> accounts = new ArrayList<>();
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int accountNum = result.getInt("ACCOUNTNUM");
                int  userId = result.getInt("USERID");
                String accounttype  = result.getString("ACCOUNTTYPE");
                AccountType type = AccountType.of(accounttype);
                int  balance = result.getInt("BALANCE");
                int associatedAccNum = result.getInt("ASSOCIATEDACCNUM");
                System.out.println(accountNum);


                AccountFactory accountFactory = new AccountFactory();
                switch (type) {
                    case CHECKING:
                    case SAVINGS:
                        accounts.add(accountFactory.makeAccount(customer, type, balance, accountNum));
                        break;
                    case SECURITY:
                        Account associatedAccount = null;
                        for (Account account :
                                customer.getAccounts()) {
                            if (account.getAccountNumber() == associatedAccNum) {
                                associatedAccount = account;
                            }
                        }
                        if(associatedAccount == null) {
                            accounts.add(new SecurityAccount(customer, accountNum, balance, associatedAccNum));
                        } else {
                            accounts.add(accountFactory.makeSecurityAccount(customer, associatedAccount, balance, accountNum));
                        }
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return accounts;
    }

    public static void insert(Account account) {
        System.out.println("Inserting new account - " + account);
        String statement = "INSERT INTO ACCOUNT (ACCOUNTNUM,USERID,ACCOUNTTYPE,BALANCE) " +
                "VALUES ("+account.getAccountNumber()+", "+account.getUser().getId()+", '"+account.getAccountType()+"', "+account.getBal()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void insertSecurityAccount(SecurityAccount account) {
        System.out.println("Inserting new account - " + account);
        String statement = "INSERT INTO ACCOUNT (ACCOUNTNUM,USERID,ACCOUNTTYPE, ASSOCIATEDACCNUM, BALANCE) " +
                "VALUES ("+account.getAccountNumber()+", "+account.getUser().getId()+", '"+account.getAccountType()+"',"+account.getSavingsAccount().getAccountNumber()+", "+account.getBal()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void update(Account account) {
        System.out.println("Updating account - " + account);
        String statement = "UPDATE ACCOUNT SET BALANCE = "+account.getBal()+" WHERE ACCOUNTNUM = "+account.getAccountNumber()+";";
        DatabaseController.getInstance().updateStatement(statement);
    }
}
