package Bank;

import Database.DatabaseController;
import User.UserInfo;
import User.UserDatabase;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomerDatabase {
    public CustomerDatabase() {
    }

    public static void createTable() {
        String statement = "CREATE TABLE CUSTOMER " +
                "(USERID INTEGER NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " DOB            TEXT     NOT NULL, " +
                " ADDRESS        CHAR(50) NOT NULL, " +
                " IDNUMBER         TEXT     NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static int insert(Customer customer) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String date = formatter.format(customer.getDateOfBirth());
        int userId = UserDatabase.insert(customer);
        String statement = "INSERT INTO CUSTOMER (USERID, NAME,DOB,ADDRESS,IDNUMBER) " +
                "VALUES ("+userId+", '"+customer.getName()+"', '"+date+"', '"+customer.getAddress()+"', '"+customer.getIdNumber()+"');";
        DatabaseController.getInstance().updateStatement(statement);
        return userId;
    }

    public static Customer getCustomerUsingID(int id) {
        String statement = "SELECT * FROM CUSTOMER  WHERE USERID="+id+";";
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            if (result.next()) {
                String  name = result.getString("NAME");
                String dob  = result.getString("DOB");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = formatter.parse(dob);
                String  address = result.getString("ADDRESS");
                String  idNum = result.getString("IDNUMBER");
                UserInfo info = UserDatabase.getUser(id);
                Customer customer = new Customer(id, name, date, address, idNum, info.getUsername(), info.getPassword());
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

    public static Customer getCustomer(String userName, String password) {
        String statement = "SELECT * FROM CUSTOMER  WHERE CUSTOMERNAME='"+userName+"' AND PASSWORD='"+password+"';";
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

                UserInfo info = UserDatabase.getUser(id);
                Customer customer = new Customer(id, name, date, address, idNum, info.getUsername(), info.getPassword());
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

    public static ArrayList<Customer> getCustomers() {
        String statement = "SELECT * FROM CUSTOMER;";
        System.out.println(statement);
        ArrayList<Customer> customers = new ArrayList<>();
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int id = result.getInt("ID");
                String  name = result.getString("NAME");
                String dob  = result.getString("DOB");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = formatter.parse(dob);
                String  address = result.getString("ADDRESS");
                String  idNum = result.getString("IDNUMBER");
                UserInfo info = UserDatabase.getUser(id);
                Customer customer = new Customer(id, name, date, address, idNum, info.getUsername(), info.getPassword());

                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return customers;
    }
}