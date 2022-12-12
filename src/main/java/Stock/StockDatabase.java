package Stock;

import Database.DatabaseController;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockDatabase {

    public StockDatabase() {}

    public static void createTable() {
        String statement = "CREATE TABLE STOCK " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME           TEXT    NOT NULL, " +
                " VALUE            REAL     NOT NULL) ";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static int insert(String name, Double value) {
        String statement = "INSERT INTO STOCK (NAME,VALUE) " +
                "VALUES ('"+name+"', "+value+" );";
        ResultSet result = DatabaseController.getInstance().runStatementWithGeneratedKeys(statement);
        try {
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }
}
