package Stock;

import Database.DatabaseController;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StockDatabase {

    public StockDatabase() {}

    public static void createTable() {
        String statement = "CREATE TABLE STOCK " +
                "(ID INTEGER PRIMARY KEY NOT NULL," +
                " SYMBOL           TEXT    NOT NULL, " +
                " NAME           TEXT    NOT NULL, " +
                " VALUE            REAL     NOT NULL) ";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static int insert(int sid, String name, String symbol, Double value) {
        String statement = "INSERT INTO STOCK (ID, SYMBOL, NAME, VALUE) " +
                "VALUES ("+sid+", '"+symbol+"', '"+name+"', "+value+" );";
        ResultSet result = DatabaseController.getInstance().runStatementWithGeneratedKeys(statement);
        try {
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }

    public static ArrayList<Stock> getStocks() {
        String statement = "SELECT * FROM STOCK;";
        System.out.println(statement);
        ArrayList<Stock> stocks = new ArrayList<>();
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int sid = result.getInt("ID");
                String  symbol = result.getString("SYMBOL");
                String name  = result.getString("NAME");
                double value  = result.getDouble("VALUE");

                stocks.add(new Stock(sid, symbol, name, value));
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return stocks;
    }

}
