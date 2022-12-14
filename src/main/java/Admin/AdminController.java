package Admin;

import Backend_Files.Customer;
import User.UserDatabase;

import java.util.ArrayList;

public class AdminController {
    public static ArrayList<Customer> getAllCustomers() {
        return UserDatabase.getCustomers();
    }
}
