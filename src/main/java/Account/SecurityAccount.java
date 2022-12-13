package Account;

import Backend_Files.Customer;

public class SecurityAccount extends Account {
    private double bal;
    private Account savingsAccount;


    SecurityAccount(Customer customer, String accountNumber){
        super(customer, accountNumber, AccountType.SECURITY);
        this.savingsAccount = null;
    }
    SecurityAccount(Customer customer, Account account, double bal, String accountNumber){
        super(customer, bal, accountNumber, AccountType.SECURITY);
        this.savingsAccount = account;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

}
