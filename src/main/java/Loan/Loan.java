package Loan;

import Account.Account;
import Database.Model;
import User.User;

import java.io.File;

public class Loan implements Model {
    private int id;
    private User loaner;
    private Account associatedAccount;
    private LoanType typeOfLoan;
    private CollateralType collateralType;
    private int repaymentPeriod;
    private File proof;

    private LoanStatus status;
    private int loanAmount;
    private int paidAmount;

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof) {
        this.id = id;
        this.loaner = loaner;
        this.associatedAccount = account;
        this.typeOfLoan = typeOfLoan;
        this.collateralType = collateralType;
        this.repaymentPeriod = repaymentPeriod;
        this.proof = proof;
        this.status = LoanStatus.SUBMITTED;
        this.loanAmount = 0;
        this.paidAmount = 0;
    }

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, LoanStatus status, int loanAmount) {
        this.id = id;
        this.loaner = loaner;
        this.associatedAccount = account;
        this.typeOfLoan = typeOfLoan;
        this.collateralType = collateralType;
        this.repaymentPeriod = repaymentPeriod;
        this.proof = proof;
        this.status = status;
        this.loanAmount = loanAmount;
        this.paidAmount = 0;
    }

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, LoanStatus status, int loanAmount, int paidAmount) {
        this.id = id;
        this.loaner = loaner;
        this.associatedAccount = account;
        this.typeOfLoan = typeOfLoan;
        this.collateralType = collateralType;
        this.repaymentPeriod = repaymentPeriod;
        this.proof = proof;
        this.status = status;
        this.loanAmount = loanAmount;
        this.paidAmount = paidAmount;
    }

    @Override
    public void update() {

    }

    @Override
    public void save() {
        int id = LoanDatabase.insert(this);
        if(id != 0) {
            this.id = id;
        }
    }

    @Override
    public String toString() {
        return this.typeOfLoan + " " + this.id;
    }

    public User getLoaner() {
        return loaner;
    }

    public Account getAssociatedAccount() {
        return associatedAccount;
    }

    public CollateralType getCollateralType() {
        return collateralType;
    }

    public File getProof() {
        return proof;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public LoanType getTypeOfLoan() {
        return typeOfLoan;
    }
}
