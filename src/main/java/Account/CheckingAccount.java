package Account;

import Backend_Files.Customer;
import Transaction.Transaction;

import java.util.ArrayList;

public class CheckingAccount extends Account {
    CheckingAccount(Customer customer, double bal, int accountNo){
        super(customer, bal, accountNo, AccountType.CHECKING);
    }
}
