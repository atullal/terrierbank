package Admin;

import Bank.Customer;
import Bank.CustomerDatabase;

import java.util.ArrayList;

public class AdminController {
    public static ArrayList<Customer> getAllCustomers() {
        return CustomerDatabase.getCustomers();
    }
}
