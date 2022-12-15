package User;

import Account.Account;
import Bank.CustomerDatabase;
import Database.Model;
import Transaction.TransactionAssociated;

import java.util.ArrayList;
import java.util.Date;

public abstract class User implements Model, TransactionAssociated {
    int id;
    String userName;
    String password;

    protected User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    protected User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
}