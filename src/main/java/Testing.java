import Stock.Stock;
import Stock.StockDatabase;

public class Testing {
    public static void main(String[] args)
    {
        StockDatabase.insert("Apple", "AAPL", 123.0);
        for (Stock stock :
                StockDatabase.getStocks()) {
            System.out.println(stock);
        }
        StockDatabase.createTable();

       


    }
}
