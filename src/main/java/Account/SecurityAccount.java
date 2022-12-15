package Account;

import Bank.Customer;

public class SecurityAccount extends Account {
    private double bal;
    private String savingsAccount;


    SecurityAccount(Customer customer, int accountNumber){
        super(customer, accountNumber, AccountType.SECURITY);
        this.savingsAccount = null;
    }
    public SecurityAccount(Customer customer, String savingsAccount, double bal, int accountNumber){
        super(customer, bal, accountNumber, AccountType.SECURITY);
        this.savingsAccount = savingsAccount;
    }

    public String getSavingsAccount() {
        return savingsAccount;
    }

}
