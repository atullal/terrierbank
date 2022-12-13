import Account.AccountDatabase;
import Transaction.TransactionDatabase;
import UI.UserOrAdminLogin;
import User.UserDatabase;

public class Main {
    public static void main(String[] args) {
        UserDatabase.createTable();
        AccountDatabase.createTable();
        TransactionDatabase.createTable();
        UserOrAdminLogin.main(args);
    }
}