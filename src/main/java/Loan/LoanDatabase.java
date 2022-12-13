package Loan;

import Account.Account;
import Database.DatabaseController;

public class LoanDatabase {
    public static void createTable() {
        String statement = "CREATE TABLE LOAN " +
                "(ACCOUNTNUM INTEGER PRIMARY KEY," +
                " USERID           INTEGER  NOT NULL, " +
                " ACCOUNTTYPE            TEXT     NOT NULL, " +
                " BALANCE        INTEGER NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void insert(Account account) {
        String statement = "INSERT INTO ACCOUNT (ACCOUNTNUM,USERID,ACCOUNTTYPE,BALANCE) " +
                "VALUES ("+account.getAccountNumber()+", "+account.getCustomer().getId()+", '"+account.getAccountType()+"', "+account.getBal()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }
}
