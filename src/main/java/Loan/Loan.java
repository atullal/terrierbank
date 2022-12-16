package Loan;

import Account.Account;
import Database.Model;
import User.User;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

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
    private int requestAmount;
    private Date loanDate;
    private double interestRate;

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount, double interestRate) {
        this.id = id;
        this.loaner = loaner;
        this.associatedAccount = account;
        this.typeOfLoan = typeOfLoan;
        this.collateralType = collateralType;
        this.repaymentPeriod = repaymentPeriod;
        this.proof = proof;
        this.status = LoanStatus.SUBMITTED;
        this.requestAmount = requestAmount;
        this.loanDate = new Date();
        this.interestRate = interestRate;
        this.loanAmount = 0;
        this.paidAmount = 0;
    }


    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount, double interestRate, Date loanDate) {
        this(id, loaner, account, typeOfLoan, collateralType, repaymentPeriod, proof, requestAmount, interestRate);
        this.loanDate = loanDate;
    }

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount, double interestRate, LoanStatus status, int loanAmount) {
        this(id, loaner, account, typeOfLoan, collateralType, repaymentPeriod, proof, requestAmount, interestRate);
        this.status = status;
        this.loanAmount = loanAmount;
    }

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount, double interestRate, Date loanDate, LoanStatus status, int loanAmount) {
        this(id, loaner, account, typeOfLoan, collateralType, repaymentPeriod, proof, requestAmount, interestRate, loanDate);
        this.status = status;
        this.loanAmount = loanAmount;
    }

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount, double interestRate, LoanStatus status, int loanAmount, int paidAmount) {
        this(id, loaner, account, typeOfLoan, collateralType, repaymentPeriod, proof, requestAmount, interestRate, status, loanAmount);
        this.paidAmount = paidAmount;
    }

    public Loan(int id, User loaner, Account account, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount, double interestRate, Date loanDate, LoanStatus status, int loanAmount, int paidAmount) {
        this(id, loaner, account, typeOfLoan, collateralType, repaymentPeriod, proof, requestAmount, interestRate, loanDate, status, loanAmount);
        this.paidAmount = paidAmount;
        this.recalculateLoan();
    }

    private void recalculateLoan() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(loanDate);
        cal.add(Calendar.YEAR, 1);
        Date nextLoanDate = cal.getTime();
        Date today = new Date();
        System.out.println("Loan date compare");
        System.out.println(nextLoanDate);
        System.out.println(today);
        if(today.compareTo(nextLoanDate) > 0) {
            this.loanDate = nextLoanDate;
            this.loanAmount = (int) (this.loanAmount + (this.loanAmount * (this.interestRate/100)));

            this.repaymentPeriod = this.repaymentPeriod - 1;
            this.update();
        }
    }

    @Override
    public void update() {
        LoanDatabase.update(this);
    }

    @Override
    public void save() {
        int id = LoanDatabase.insert(this);
        if(id != 0) {
            this.id = id;
        }
    }

    public void pay(int amount) {
        this.paidAmount = this.paidAmount + amount;
        if(this.paidAmount >= this.loanAmount) {
            this.status = LoanStatus.PAID;
        }
        this.update();
    }

    public void approve(int sanctionAmount, double interestRate) {
        this.status = LoanStatus.APPROVED;
        this.loanAmount = sanctionAmount;
        this.interestRate = interestRate;
        this.update();
    }

    public void deny() {
        this.status = LoanStatus.DENIED;
        this.update();
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

    public int getId() {
        return id;
    }

    public int getRequestAmount() {
        return requestAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
