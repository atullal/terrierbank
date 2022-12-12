package User;

import Database.Database;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class UserDatabase {
    public UserDatabase() {
    }

    public static void createUserTable() {
        String statement = "CREATE TABLE USER " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME           TEXT    NOT NULL, " +
                " DOB            TEXT     NOT NULL, " +
                " ADDRESS        CHAR(50) NOT NULL, " +
                " IDNUMBER         TEXT     NOT NULL,"+
                " USERNAME         TEXT     NOT NULL,"+
                " PASSWORD         TEXT     NOT NULL)";
        Database.getInstance().updateStatement(statement);
    }

    public static int insertUser(String name, Date dob, String address, String idNumber, String userName, String password) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String date = formatter.format(dob);
        String statement = "INSERT INTO USER (NAME,DOB,ADDRESS,IDNUMBER, USERNAME, PASSWORD) " +
                "VALUES ('"+name+"', '"+date+"', '"+address+"', '"+idNumber+"', '"+userName+"', '"+password+"' );";
        ResultSet result = Database.getInstance().runStatementWithGeneratedKeys(statement);
        try {
            if (result.next()) {
                System.out.println(result.getInt(1));
                return result.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }

    public static User getUser(String userName, String password) {
        String statement = "SELECT * FROM USER  WHERE USERNAME='"+userName+"' AND PASSWORD='"+password+"';";
        ResultSet result = Database.getInstance().queryStatement(statement);
        try {
            if (result.next()) {
                int id = result.getInt("ID");
                String  name = result.getString("NAME");
                String dob  = result.getString("DOB");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = formatter.parse(dob);
                String  address = result.getString("ADDRESS");
                String  idNum = result.getString("IDNUMBER");
                String  user = result.getString("USERNAME");
                String  pass = result.getString("PASSWORD");
                return new User(id, name, date, address, idNum, user, pass);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return null;
    }
}