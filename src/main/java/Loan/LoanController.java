package Loan;

import Account.Account;
import Backend_Files.Customer;
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

    public Loan newLoan(Account selectedAccount, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof) {
        Loan loan = new Loan(0, UserController.getInstance().getLoggedInUser(), selectedAccount, typeOfLoan, collateralType, repaymentPeriod, proof);
        loan.save();
        ((Customer) UserController.getInstance().getLoggedInUser()).addLoan(loan);
        System.out.println(loan);
        return loan;
    }
}
