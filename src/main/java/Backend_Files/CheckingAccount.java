package Backend_Files;

public class CheckingAccount extends Account {

    private int bal;

    CheckingAccount(){
        this.bal = 0;
    }

    CheckingAccount(int bal){
        this.bal = bal;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }
}
