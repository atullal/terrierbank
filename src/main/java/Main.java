import Account.AccountDatabase;
import Loan.LoanDatabase;
import Stock.Stock;
import Stock.StockDatabase;
import Transaction.TransactionDatabase;
import UI.UserOrAdminLogin;
import User.UserDatabase;

public class Main {
    public static void main(String[] args) {
        createTables();
        UserOrAdminLogin.main(args);
    }

    private static void createTables() {
        UserDatabase.createTable();
        AccountDatabase.createTable();
        TransactionDatabase.createTable();
        StockDatabase.createTable();
        LoanDatabase.createTable();
    }
}