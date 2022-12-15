import Account.AccountDatabase;
import Bank.BankController;
import Bank.BankManager;
import Bank.CustomerDatabase;
import Loan.LoanDatabase;
import Stock.Stock;
import Stock.StockDatabase;
import Transaction.TransactionDatabase;
import UI.UserOrAdminLogin;
import User.UserDatabase;

public class Main {
    public static void main(String[] args) {
        createTables();
        initializeApplication();
        UserOrAdminLogin.main(args);
    }

    private static void createTables() {
        UserDatabase.createTable();
        CustomerDatabase.createTable();
        AccountDatabase.createTable();
        TransactionDatabase.createTable();
        StockDatabase.createTable();
        LoanDatabase.createTable();
    }

    private static void initializeApplication() {
        if(!BankController.getInstance().isBankManagerInitialized()) {
            BankManager manager = BankController.getInstance().createBankManager();
            manager.save();
            BankController.getInstance().createBankManagerAccount(manager);
        }
    }
}