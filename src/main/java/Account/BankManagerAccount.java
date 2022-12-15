package Account;

import Bank.BankManager;

public class BankManagerAccount extends Account {
    public BankManagerAccount(BankManager bankManager, double bal, int accountNo){
        super(bankManager, bal, accountNo, AccountType.MANAGER);
    }
}
