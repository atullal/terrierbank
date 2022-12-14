package Account;

import Backend_Files.Customer;

public class SavingsAccount extends Account{
    SavingsAccount(Customer customer, double bal, int accountNo){
        super(customer, bal, accountNo, AccountType.SAVINGS);
    }
}
