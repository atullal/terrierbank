package Transaction;

import Account.Account;
import Database.DatabaseController;

import java.util.Date;

public class TransactionDatabase {

    public static void createTable() {
        String statement = "CREATE TABLE TRANSCATIONS " +
                "(TRANSCATIONID INTEGER PRIMARY KEY," +
                " DATE           STRING  NOT NULL, " +
                " TIME            STRING     NOT NULL, " +
                " FROMACC        STRING NOT NULL," +
                "TOACC        STRING NOT NULL," +
                "AMOUNT        DOUBLE NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void insert(int id, String date, String time, String from, String to, double amount) {
        String statement = "INSERT INTO TRANSACTIONS (TRANSCATIONID,DATE,TIME,FROMACC,TOACC,AMOUNT) " +
                "VALUES ("+id+", "+date+", '"+time+"', "+from+"', "+to+"', "+amount+");";
        DatabaseController.getInstance().updateStatement(statement);
    }
}
