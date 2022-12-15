import Account.SavingsAccount;
import Account.SecurityAccount;
import Stock.Stock;
import Stock.StockDatabase;
import Bank.Customer;
import Stock.StockMarket;
import Stock.StockPosition;
import Stock.StockPositionDatabase;

import java.util.ArrayList;
import java.util.Date;

public class Testing {
    public static void main(String[] args)
    {
        //StockDatabase.insert("Apple", "AAPL", 123.0);
        for (Stock stock :
                StockDatabase.getStocks()) {
            System.out.println(stock);
        }


        //SecurityAccount acc = new SecurityAccount()
        //String name, Date dateOfBirth, String address, String idNumber, String userName, String password)
        StockPositionDatabase.createTable();
        ArrayList<Stock> stocks = StockDatabase.getStocks();

        StockPosition sp;
        ArrayList<StockPosition> stockPositions;
        Date date = new Date();
        Customer c1 = new Customer("Spunny" , date, "Boston" , "1001" , "spunnyBunny", "");
        SavingsAccount s = new SavingsAccount(c1, 10000, 12001000);
        SecurityAccount sec = new SecurityAccount(c1, "savings", 50000, 30129000);


        StockMarket stockMarket = StockMarket.getInstance();

        System.out.println("1: Account Balance " + sec.getBal());
        sp = stockMarket.buyStock(stocks.get(0), c1, sec, 2);
        System.out.println(sp.toString());
        System.out.println("2: Account Balance " + sec.getBal());
        sp = stockMarket.buyStock(stocks.get(1), c1, sec, 50);
        System.out.println(sp.toString());
        System.out.println("3: Account Balance " + sec.getBal());



        //System.out.println("Here are your stock Positions: " );
        stockPositions = stockMarket.returnOpenPosition(c1);
        for( StockPosition stockPos : stockMarket.returnOpenPosition(c1)){
            System.out.println(stockPos.toString());
        }
        sp = stockMarket.sellStock(1, c1, sec);
        System.out.println("Sold Stock " +sp.toString());

        System.out.println("Selling Stock!");
        for( StockPosition stockPos : stockMarket.returnOpenPosition(c1)){
            System.out.println(stockPos.toString());
        }
        System.out.println("4: Account Balance " + sec.getBal());








       


    }
}
