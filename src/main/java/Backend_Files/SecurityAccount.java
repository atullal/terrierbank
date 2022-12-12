package Backend_Files;

public class SecurityAccount extends Account{
    private double bal;
    private Account savingsAccount;

    SecurityAccount(){
        this.bal = 0;
        this.savingsAccount = null;
    }
    SecurityAccount(Account account, int bal){
        this.savingsAccount = account;
        this.bal = bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public double getBal() {
        return bal;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }
}
