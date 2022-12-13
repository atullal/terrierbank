import Account.AccountDatabase;
import UI.UserOrAdminLogin;
import User.UserDatabase;

public class Main {
    public static void main(String[] args) {
        UserDatabase.createTable();
        AccountDatabase.createTable();
        UserOrAdminLogin.main(args);
    }
}