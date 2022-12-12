package Backend_Files;

import User.User;

import java.util.Date;

public class Customer extends User {
    public Customer(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(name, dateOfBirth, address, idNumber, userName, password);
    }

    public Customer(int id, String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        super(id, name, dateOfBirth, address, idNumber, userName, password);
    }
}
