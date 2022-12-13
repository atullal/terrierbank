package Loan;

import Account.Account;
import User.UserController;

import java.io.File;

public class LoanController {
    private static LoanController instance = null;

    private LoanController() {}

    public static LoanController getInstance() {
        if (instance == null) {
            instance = new LoanController();
        }
        return instance;
    }

    public boolean newLoan(String accountNumber, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof) {
        Account selectedAccount = null;
        Loan loan = new Loan(UserController.getInstance().getLoggedInUser(), selectedAccount, typeOfLoan, collateralType, repaymentPeriod, proof);
        loan.save();
        System.out.println(loan);
        return false;
    }
}
