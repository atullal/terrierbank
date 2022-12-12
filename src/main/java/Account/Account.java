package Account;

public abstract class Account {
    private double bal;

    public Account(){
        this.bal = 0;
    }
    public Account(double bal){
        this.bal = bal;
    }
    public double getAmount() {

        return bal;
    }

    public void setAmount(double bal) {
        this.bal = bal;
    }
}
