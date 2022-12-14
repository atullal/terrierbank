package User;

import Backend_Files.Customer;
import Database.DatabaseController;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDatabase {
    public UserDatabase() {
    }

    public static void createTable() {
        String statement = "CREATE TABLE USER " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME           TEXT    NOT NULL, " +
                " DOB            TEXT     NOT NULL, " +
                " ADDRESS        CHAR(50) NOT NULL, " +
                " IDNUMBER         TEXT     NOT NULL,"+
                " USERNAME         TEXT     NOT NULL,"+
                " PASSWORD         TEXT     NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static int insert(User user) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String date = formatter.format(user.getDateOfBirth());
        String statement = "INSERT INTO USER (NAME,DOB,ADDRESS,IDNUMBER, USERNAME, PASSWORD) " +
                "VALUES ('"+user.getName()+"', '"+date+"', '"+user.getAddress()+"', '"+user.getIdNumber()+"', '"+user.getUserName()+"', '"+user.getPassword()+"' );";
        ResultSet result = DatabaseController.getInstance().runStatementWithGeneratedKeys(statement);
        try {
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }



    public static Customer getCustomer(String userName, String password) {
        String statement = "SELECT * FROM USER  WHERE USERNAME='"+userName+"' AND PASSWORD='"+password+"';";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
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
                Customer customer = new Customer(id, name, date, address, idNum, user, pass);
                customer.fetchAccounts();
                customer.fetchLoans();
                return customer;
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return null;
    }
}