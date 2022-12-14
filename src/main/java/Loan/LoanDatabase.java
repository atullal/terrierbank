package Loan;

import Account.Account;
import Backend_Files.Customer;
import Database.DatabaseController;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;

//private User loaner;
//private Account associatedAccount;
//private LoanType typeOfLoan;
//private CollateralType collateralType;
//private int repaymentPeriod;
//private File proof;
//
//private LoanStatus status;
//private int loanAmount;
//private int paidAmount;

public class LoanDatabase {
    public static void createTable() {
        String statement = "CREATE TABLE LOAN " +
                "(LOANID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USERID           INTEGER  NOT NULL, " +
                " ACCOUNTNUM           INTEGER  NOT NULL, " +
                " LOANTYPE            TEXT     NOT NULL, " +
                " COLLATERALTYPE            TEXT     NOT NULL, " +
                " REPAYMENT           INTEGER  NOT NULL, " +
                " PROOF           TEXT  NOT NULL, " +
                " STATUS           TEXT  NOT NULL, " +
                " LOANAMOUNT           INTEGER  NOT NULL, " +
                " PAIDAMOUNT        INTEGER NOT NULL)";
        DatabaseController.getInstance().updateStatement(statement);
    }

    public static int insert(Loan loan) {
        String statement = "INSERT INTO LOAN (USERID, ACCOUNTNUM, LOANTYPE, COLLATERALTYPE, REPAYMENT, PROOF, STATUS, LOANAMOUNT, PAIDAMOUNT) " +
                "VALUES ("+loan.getLoaner().getId()+", "+loan.getAssociatedAccount().getAccountNumber()+", '"+loan.getTypeOfLoan()+"', '"+loan.getCollateralType()+"', "+loan.getRepaymentPeriod()+", '"+loan.getProof().getPath()+"', '"+loan.getStatus()+"', "+loan.getLoanAmount()+", "+loan.getPaidAmount()+");";
        ResultSet result = DatabaseController.getInstance().runStatementWithGeneratedKeys(statement);
        try {
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }

    public static ArrayList<Loan> getLoans(Customer customer) {
        String statement = "SELECT * FROM LOAN WHERE USERID="+customer.getId()+";";
        System.out.println(statement);
        ArrayList<Loan> loans = new ArrayList<>();
        ResultSet result = DatabaseController.getInstance().queryStatement(statement);
        try {
            while (result.next()) {
                int loanid = result.getInt("LOANID");
                int  accountNum = result.getInt("ACCOUNTNUM");
                String loantype = result.getString("LOANTYPE");
                String collateraltype = result.getString("COLLATERALTYPE");
                int  repayment = result.getInt("REPAYMENT");
                String proof = result.getString("PROOF");
                String status = result.getString("STATUS");
                int  loanamount = result.getInt("LOANAMOUNT");
                int  paidamount = result.getInt("PAIDAMOUNT");
                Account associatedAccount = null;
                for (Account account :
                        customer.getAccounts()) {
                    if (account.getAccountNumber() == accountNum) {
                        associatedAccount = account;
                    }
                }
                if(associatedAccount != null) {
                    loans.add(new Loan(loanid, customer, associatedAccount, LoanType.of(loantype), CollateralType.of(collateraltype), repayment, new File(proof), LoanStatus.of(status), loanamount, paidamount));
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot find the loans");
            System.out.println(e);
        }
        return loans;
    }

    public static void update(Loan loan) {

        String statement = "UPDATE LOAN SET STATUS = '"+loan.getStatus()+"', LOANAMOUNT = "+loan.getLoanAmount()+", PAIDAMOUNT = "+loan.getPaidAmount()+" WHERE LOANID = "+loan.getId()+";";
        DatabaseController.getInstance().updateStatement(statement);
    }

}
