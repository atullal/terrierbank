package Backend_Files;

public class SavingsAccount extends Account{

    private int bal;

    SavingsAccount(){
        this.bal = 0;
    }

    SavingsAccount(int bal){
        this.bal = bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public int getBal() {
        return bal;
    }
}
