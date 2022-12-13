package Account;

import Backend_Files.Customer;

public class SecurityAccount extends Account {
    private double bal;
    private String savingsAccount;


    SecurityAccount(Customer customer, String accountNumber){
        super(customer, accountNumber, AccountType.SECURITY);
        this.savingsAccount = null;
    }
    SecurityAccount(Customer customer, String savingsAccount, double bal, String accountNumber){
        super(customer, bal, accountNumber, AccountType.SECURITY);
        this.savingsAccount = savingsAccount;
    }

    public String getSavingsAccount() {
        return savingsAccount;
    }

}
