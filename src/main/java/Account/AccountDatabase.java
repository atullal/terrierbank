package Account;

import Backend_Files.Customer;
import Database.DatabaseController;
import User.UserDatabase;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountDatabase {

    public static void createTable() {
        String statement = "CREATE TABLE ACCOUNT " +
                "(ACCOUNTNUM INTEGER PRIMARY KEY," +
                " USERID           INTEGER  NOT NULL, " +
                " ACCOUNTTYPE            TEXT     NOT NULL, " +
                " BALANCE        INTEGER NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static Account getAccountFromNumber(int accountNum) {
        Account account = null;
        String statement = "SELECT * FROM ACCOUNT WHERE ACCOUNTNUM="+accountNum+";";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int  userId = result.getInt("USERID");
                Customer customer = UserDatabase.getCustomerUsingID(userId);
                customer.fetchLoans();
                customer.fetchAccounts();
                String accounttype  = result.getString("ACCOUNTTYPE");
                AccountType type = AccountType.of(accounttype);
                int  balance = result.getInt("BALANCE");
                System.out.println(accountNum);

                AccountFactory accountFactory = new AccountFactory();
                switch (type) {
                    case CHECKING:
                    case SAVINGS:
                        account = accountFactory.makeAccount(customer, type, balance, accountNum);
                        break;
                    case SECURITY:
                        // TODO: Add security account
//                        accounts.add(accountFactory.makeSecurityAccount(customer, type, balance, String.valueOf(accountNum)));
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
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
                System.out.println(accountNum);

                AccountFactory accountFactory = new AccountFactory();
                switch (type) {
                    case CHECKING:
                    case SAVINGS:
                        accounts.add(accountFactory.makeAccount(customer, type, balance, accountNum));
                        break;
                    case SECURITY:
                        // TODO: Add security account
//                        accounts.add(accountFactory.makeSecurityAccount(customer, type, balance, String.valueOf(accountNum)));
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
                "VALUES ("+account.getAccountNumber()+", "+account.getCustomer().getId()+", '"+account.getAccountType()+"', "+account.getBal()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void update(Account account) {
        System.out.println("Updating account - " + account);
        String statement = "UPDATE ACCOUNT SET BALANCE = "+account.getBal()+" WHERE ACCOUNTNUM = "+account.getAccountNumber()+";";
        DatabaseController.getInstance().updateStatement(statement);
    }
}
