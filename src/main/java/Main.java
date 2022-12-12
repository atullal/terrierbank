import User.UserDatabase;

public class Main {
    public static void main(String[] args) {
        UserDatabase.createUserTable();
        UserOrAdminLogin.main(args);
    }
}