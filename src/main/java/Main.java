import Account.AccountDatabase;
import Stock.Stock;
import Stock.StockDatabase;
import Transaction.TransactionDatabase;
import UI.UserOrAdminLogin;
import User.UserDatabase;

public class Main {
    public static void main(String[] args) {
        UserDatabase.createTable();
        AccountDatabase.createTable();
        TransactionDatabase.createTable();
        StockDatabase.createTable();
//        StockDatabase.insert("Apple", "AAPL", 123.0);
//        for (Stock stock :
//                StockDatabase.getStocks()) {
//            System.out.println(stock);
//        }
        UserOrAdminLogin.main(args);
    }
}