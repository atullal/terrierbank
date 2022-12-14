package User;

import Account.Account;
import Database.Model;

import java.util.ArrayList;
import java.util.Date;

public abstract class User implements Model {
    int id;
    String name;
    Date dateOfBirth;
    String address;
    String idNumber;
    String userName;
    String password;

    protected User(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idNumber = idNumber;
        this.userName = userName;
        this.password = password;
    }

    protected User(int id, String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idNumber = idNumber;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void save() {
        int id = UserDatabase.insert(this);
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void update() {

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}