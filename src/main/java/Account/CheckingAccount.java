package Account;

import Bank.Customer;

public class CheckingAccount extends Account {
    CheckingAccount(Customer customer, double bal, int accountNo){
        super(customer, bal, accountNo, AccountType.CHECKING);
    }
}
