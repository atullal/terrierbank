package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    Connection databaseConnection;

    public Connector() {
        try {
            databaseConnection = DriverManager.getConnection("jdbc:sqlite:bank.db");
            databaseConnection.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("Unable to connect database");
            System.out.println(e);
        }
    }

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }
}