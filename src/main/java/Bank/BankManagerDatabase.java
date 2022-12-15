package Bank;

import Database.DatabaseController;
import User.UserDatabase;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankManagerDatabase {

    public static void createTable() {
        String statement = "CREATE TABLE MANAGER " +
                "(USERID INTEGER NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static int insert(BankManager manager) {
        int userId = UserDatabase.insert(manager);
        String statement = "INSERT INTO MANAGER (USERID) " +
                "VALUES ("+userId+");";
        DatabaseController.getInstance().updateStatement(statement);
        return userId;
    }

}
