package User;

import Database.Model;

import java.util.Date;

public class User implements Model {
    int id;
    String name;
    Date dateOfBirth;
    String address;
    String idNumber;
    String userName;
    String password;

    public User(String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idNumber = idNumber;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String name, Date dateOfBirth, String address, String idNumber, String userName, String password) {
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
        int id = UserDatabase.insertUser(this.name, this.dateOfBirth, this.address, this.idNumber, this.userName, this.password);
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