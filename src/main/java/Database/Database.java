package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private static Database instance = null;
    Connector databaseConnector;

    private Database() {
        databaseConnector = new Connector();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void updateStatement(String statement) {
        try {
            Statement stmt = databaseConnector.getDatabaseConnection().createStatement();
            stmt.executeUpdate(statement);
            stmt.close();
            databaseConnector.getDatabaseConnection().commit();
        } catch (Exception e) {
            System.out.println("Unable to create table");
            System.out.println(e);
        }
    }

    public ResultSet queryStatement(String statement) {
        try {
            Statement stmt = databaseConnector.getDatabaseConnection().createStatement();
            ResultSet result = stmt.executeQuery(statement);
            databaseConnector.getDatabaseConnection().commit();
            return result;
        } catch (Exception e) {
            System.out.println("Unable to create table");
            System.out.println(e);
        }
        return null;
    }

    public ResultSet runStatementWithGeneratedKeys(String statement) {
        try {
            PreparedStatement stmt = databaseConnector.getDatabaseConnection().prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            stmt.close();
            databaseConnector.getDatabaseConnection().commit();
            return rs;
        } catch (Exception e) {
            System.out.println("Unable to create table");
            System.out.println(e);
        }
        return null;
    }
}