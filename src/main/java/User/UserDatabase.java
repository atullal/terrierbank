package User;

import Bank.Customer;
import Database.DatabaseController;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDatabase {

    public static void createTable() {
        String statement = "CREATE TABLE USER " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USERNAME         TEXT     NOT NULL,"+
                " PASSWORD         TEXT     NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }


    public static int insert(User user) {
        String statement = "INSERT INTO USER (USERNAME, PASSWORD) " +
                "VALUES ('"+user.getUserName()+"', '"+user.getPassword()+"' );";
        ResultSet result = DatabaseController.getInstance().runStatementWithGeneratedKeys(statement);
        try {
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }

    public static UserInfo getUser(int id) {
        String statement = "SELECT * FROM USER WHERE ID="+id+";";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            if (result.next()) {
                return new UserInfo(id, result.getString("USERNAME"), result.getString("PASSWORD"));
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return null;
    }
}
