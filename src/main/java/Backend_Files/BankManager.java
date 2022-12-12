package Backend_Files;

import User.User;

import java.util.Date;

public class BankManager extends User {
    protected BankManager(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(name, dateOfBirth, address, idNumber, userName, password);
    }

    protected BankManager(int id, String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(id, name, dateOfBirth, address, idNumber, userName, password);
    }
}
