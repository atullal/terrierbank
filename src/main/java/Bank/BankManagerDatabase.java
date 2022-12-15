package Bank;

import Database.DatabaseController;
import User.UserDatabase;
import User.UserInfo;

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

    public static BankManager getBankManager(String userName, String password) {
        String statement = "SELECT * FROM MANAGER INNER JOIN USER ON USER.ID = MANAGER.USERID WHERE USERNAME='"+userName+"' AND PASSWORD='"+password+"';";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            if (result.next()) {
                int id = result.getInt("ID");
                UserInfo info = UserDatabase.getUser(id);
                return new BankManager(id, info.getUsername(), info.getPassword());
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return null;
    }


}
