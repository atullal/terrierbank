package Account;

import Backend_Files.Customer;

public class CheckingAccount extends Account {
    CheckingAccount(Customer customer, double bal, int accountNo){
        super(customer, bal, accountNo, AccountType.CHECKING);
    }
}
