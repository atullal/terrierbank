package Account;

import Bank.Customer;

public class SecurityAccount extends Account {
    private double bal;
    private Account savingsAccount;

    private int savingsAccountNum;

    private boolean isSavingsAccountFetched;

    SecurityAccount(Customer customer, int accountNumber, double bal, int savingsAccountNum){
        super(customer, accountNumber, AccountType.SECURITY);
        this.savingsAccountNum = savingsAccountNum;
        this.bal = bal;
        this.isSavingsAccountFetched = false;
        this.savingsAccount = null;
    }
    public SecurityAccount(Customer customer, Account savingsAccount, double bal, int accountNumber){
        super(customer, bal, accountNumber, AccountType.SECURITY);
        if(savingsAccount != null) {
            this.savingsAccountNum = savingsAccount.getAccountNumber();
            this.isSavingsAccountFetched = true;
        } else {
            this.isSavingsAccountFetched = false;
        }
        this.savingsAccount = savingsAccount;
    }

    public void fetchSavingsAccount() {
        Account savingsAccount = null;
        for (Account account :
                ((Customer) super.getUser()).getSavingAccounts()) {
            if(account.getAccountNumber() == savingsAccountNum) {
                savingsAccount = account;
            }
        }
        if(savingsAccount != null) {
            this.savingsAccount =savingsAccount;
            this.isSavingsAccountFetched = true;
        }
    }

    @Override
    public void save() {
        AccountDatabase.insertSecurityAccount(this);
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

}
