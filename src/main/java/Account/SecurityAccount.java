package Account;

public class SecurityAccount extends Account {
    private double bal;
    private Account savingsAccount;

    SecurityAccount(){
        super();
        this.savingsAccount = null;
    }
    SecurityAccount(Account account, double bal){
        super(bal);
        this.savingsAccount = account;

    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }


}
