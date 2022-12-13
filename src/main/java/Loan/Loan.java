package Loan;

import Account.Account;
import Database.Model;
import User.User;

import java.io.File;

public class Loan implements Model {
    private User loaner;
    private Account associatedAccount;
    private LoanType typeOfLoan;
    private CollateralType collateralType;
    private int repaymentPeriod;
    private File proof;

    private LoanStatus status;
    private int loanAmount;
    private int paidAmount;

    public Loan(User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof) {
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

    public Loan(User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, LoanStatus status, int loanAmount) {
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

    public Loan(User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, LoanStatus status, int loanAmount, int paidAmount) {
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
    public void save() {

    }

    @Override
    public String toString() {
        return "Loan{" +
                "loaner=" + loaner +
                ", associatedAccount=" + associatedAccount +
                ", typeOfLoan=" + typeOfLoan +
                ", collateralType=" + collateralType +
                ", repaymentPeriod=" + repaymentPeriod +
                ", proof=" + proof +
                ", status=" + status +
                ", loanAmount=" + loanAmount +
                ", paidAmount=" + paidAmount +
                '}';
    }
}
