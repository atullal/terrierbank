package Account;

import Bank.Customer;

public class SavingsAccount extends Account{
    public SavingsAccount(Customer customer, double bal, int accountNo){
        super(customer, bal, accountNo, AccountType.SAVINGS);
    }
}
