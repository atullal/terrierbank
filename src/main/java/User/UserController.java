package User;

import Bank.BankManager;
import Bank.BankManagerDatabase;
import Bank.Customer;
import Bank.CustomerDatabase;

import java.util.Date;

public class UserController {
    private static UserController instance = null;

    private User loggedInUser;
    private boolean isLoggedIn;
    private boolean isAdmin;

    private UserController() {
        this.isLoggedIn = false;
        this.isAdmin = false;
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public boolean customerLogin(String username, String password) {
        Customer user = CustomerDatabase.getCustomer(username, password);
        if(user != null) {
            System.out.println(user);
            loggedInUser = user;
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public boolean adminLogin(String username, String password) {
        BankManager manager = BankManagerDatabase.getBankManager(username, password);
        System.out.println(manager);
        if(manager != null) {
            System.out.println("Logging manager in");
            System.out.println(manager);
            loggedInUser = manager;
            isLoggedIn = true;
            isAdmin = true;
            return true;
        }
        return false;
    }

    public void logout() {
        loggedInUser = null;
        isLoggedIn = false;
        isAdmin = false;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void addUser(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        User user = new Customer(name, dateOfBirth, address, idNumber, userName, password);
        user.save();
    }
}