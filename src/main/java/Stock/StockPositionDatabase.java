package Stock;

import Database.DatabaseController;

import java.sql.ResultSet;

public class StockPositionDatabase {

    public StockPositionDatabase(){}

    public static void createTable() {
        String statement = "CREATE TABLE STOCKPOSITION " +
                "(STOCKPOS INTEGER PRIMARY KEY AUTOINCREMENT," +
                " SID           INTEGER    NOT NULL, " +
                " USERID        INTEGER  NOT NULL," +
                " ACCOUNTNUM           INTEGER  NOT NULL) " +
                " NUMSHARES      INTEGER  ,)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void insert(StockPosition sp) {
        System.out.println("Inserting new stockPosition - " + sp);
        String statement = "INSERT INTO STOCKPOSITION (STOCKPOS, SID, USERID,ACCOUNTNUM, NUMSHARES) " +
                "VALUES ("+ sp.getStockPos()+", "+ sp.getStock().getSid()+", '"+ sp.getUser().getId()+"',"+ sp.getAcc().getAccountNumber()+", "+ sp.getNumShares()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }

}
