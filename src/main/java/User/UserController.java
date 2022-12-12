package User;

import Database.Database;

import java.util.ArrayList;
import java.util.Date;

public class UserController {
    private static UserController instance = null;

    private User loggedInUser;
    private boolean isLoggedIn;

    private UserController() {
        this.isLoggedIn = false;
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public void login(String username, String password) {
        User user = UserDatabase.getUser(username, password);
        if(user != null) {
            System.out.println(user);
            loggedInUser = user;
            isLoggedIn = true;
        }
    }

    public void logout(String username, String password) {
        loggedInUser = null;
        isLoggedIn = false;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void addUser(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        User user = new User(name, dateOfBirth, address, idNumber, userName, password);
        user.save();
    }
}