package Bank;

import Account.AccountDatabase;
import Account.BankManagerAccount;

import java.util.Date;

public class BankController {

    private static BankController instance = null;


    public static BankController getInstance() {
        if (instance == null) {
            instance = new BankController();
        }
        return instance;
    }

    public boolean isBankManagerInitialized() {
        if(BankManagerDatabase.getBankManager("admin", "12345") != null) {
            return true;
        }
        return false;
    }


    public void createBankManagerAccount(BankManager manager) {
        AccountDatabase.insert(new BankManagerAccount(manager, 200000, 999999999));
    }

    public BankManagerAccount getBankManagerAccount() {
        BankManagerAccount account =  AccountDatabase.getBankManagerAccount();
        System.out.println(account);
        return account;
    }

    public BankManager createBankManager() {
        return new BankManager("admin", "12345");
    }
}
