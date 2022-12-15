package Transaction;

import Account.Account;
import Account.AccountDatabase;
import Bank.Customer;
import Database.DatabaseController;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionDatabase {

    public static void createTable() {
        String statement = "CREATE TABLE TRANSACTIONS " +
                "(TRANSCATIONID INTEGER PRIMARY KEY," +
                " DATE           STRING  NOT NULL, " +
                " TIME            STRING     NOT NULL, " +
                " FROMACC        STRING NOT NULL," +
                "TOACC        STRING NOT NULL," +
                "AMOUNT        REAL NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static void insert(int id, String date, String time, String from, String to, double amount) {
        String statement = "INSERT INTO TRANSACTIONS (TRANSCATIONID,DATE,TIME,FROMACC,TOACC,AMOUNT) " +
                "VALUES ("+id+", '"+date+"', '"+time+"', '"+from+"', '"+to+"', "+amount+");";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static ArrayList<Transaction> getTransactions(Account account) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String statement = "SELECT * FROM TRANSACTIONS WHERE FROMACC='"+account.getAccountNumber()+"' OR TOACC='"+account.getAccountNumber()+"';";
        System.out.println(statement);
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int id = result.getInt("TRANSCATIONID");
                String date  = result.getString("DATE");
                String time  = result.getString("TIME");
                String from = result.getString("FROMACC");
                String to = result.getString("TOACC");
                double amount = result.getDouble("AMOUNT");

                Account sender = null;
                Account receiver = null;
                TransactionType type = TransactionType.TRANSFER;
                if(!from.equals("Self")) {
                    sender = AccountDatabase.getAccountFromNumber(Integer.parseInt(from));
                } else {
                    type = TransactionType.DEPOSIT;
                }
                if(!to.equals("Cash")) {
                    receiver = AccountDatabase.getAccountFromNumber(Integer.parseInt(to));
                } else {
                    type = TransactionType.WITHDRAW;
                }
                transactions.add(new Transaction(sender, receiver, amount, type, id, date, time));
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return transactions;
    }

    public static ArrayList<Transaction> getTransactions(Customer customer) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String statement = "SELECT * FROM TRANSACTIONS LEFT JOIN ACCOUNT AS FROMACCOUNT ON FROMACCOUNT.ACCOUNTNUM == TRANSACTIONS.FROMACC LEFT JOIN ACCOUNT AS TOACCOUNT ON TOACCOUNT.ACCOUNTNUM == TRANSACTIONS.TOACC WHERE FROMACCOUNT.USERID = "+customer.getId()+" OR TOACCOUNT.USERID = "+customer.getId()+";";
        System.out.println(statement);
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int id = result.getInt("TRANSCATIONID");
                String date  = result.getString("DATE");
                String time  = result.getString("TIME");
                String from = result.getString("FROMACC");
                String to = result.getString("TOACC");
                double amount = result.getDouble("AMOUNT");

                Account sender = null;
                Account receiver = null;
                TransactionType type = TransactionType.TRANSFER;
                if(!from.equals("Self")) {
                    sender = AccountDatabase.getAccountFromNumber(Integer.parseInt(from));
                } else {
                    type = TransactionType.DEPOSIT;
                }
                if(!to.equals("Cash")) {
                    receiver = AccountDatabase.getAccountFromNumber(Integer.parseInt(to));
                } else {
                    type = TransactionType.WITHDRAW;
                }
                transactions.add(new Transaction(sender, receiver, amount, type, id, date, time));
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return transactions;
    }

    public static ArrayList<Transaction> getAllTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String statement = "SELECT * FROM TRANSACTIONS;=";
        System.out.println(statement);
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int id = result.getInt("TRANSCATIONID");
                String date  = result.getString("DATE");
                String time  = result.getString("TIME");
                String from = result.getString("FROMACC");
                String to = result.getString("TOACC");
                double amount = result.getDouble("AMOUNT");

                Account sender = null;
                Account receiver = null;
                TransactionType type = TransactionType.TRANSFER;
                if(!from.equals("Self")) {
                    sender = AccountDatabase.getAccountFromNumber(Integer.parseInt(from));
                } else {
                    type = TransactionType.DEPOSIT;
                }
                if(!to.equals("Cash")) {
                    receiver = AccountDatabase.getAccountFromNumber(Integer.parseInt(to));
                } else {
                    type = TransactionType.WITHDRAW;
                }
                transactions.add(new Transaction(sender, receiver, amount, type, id, date, time));
            }
        } catch (Exception e) {
            System.out.println("Cannot find the user");
            System.out.println(e);
        }
        return transactions;
    }

}
