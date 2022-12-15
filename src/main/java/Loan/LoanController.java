package Loan;

import Account.Account;
import Bank.Customer;
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

    public Loan newLoan(Account selectedAccount, LoanType typeOfLoan, CollateralType collateralType, int repaymentPeriod, File proof, int requestAmount) {
        Loan loan = new Loan(0, UserController.getInstance().getLoggedInUser(), selectedAccount, typeOfLoan, collateralType, repaymentPeriod, proof, requestAmount, 5.5);
        loan.save();
        ((Customer) UserController.getInstance().getLoggedInUser()).addLoan(loan);
        System.out.println(loan);
        return loan;
    }
}
