package Account;

import Database.DatabaseController;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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

    public static void insert(Account account) {
        String statement = "INSERT INTO ACCOUNT (ACCOUNTNUM,USERID,ACCOUNTTYPE,BALANCE) " +
                "VALUES ("+account.getAccountNumber()+", "+account.getCustomer().getId()+", '"+account.getAccountType()+"', "+account.getBal()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }
}
