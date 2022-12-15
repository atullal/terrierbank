package Bank;

import Transaction.Transaction;
import Transaction.TransactionAssociated;
import Transaction.TransactionDatabase;
import User.User;

import java.util.ArrayList;
import java.util.Date;

public class BankManager extends User implements TransactionAssociated {

    protected BankManager(String userName, String password) {
        super(userName, password);
    }

    protected BankManager(int id, String userName, String password) {
        super(id, userName, password);
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return TransactionDatabase.getAllTransactions();
    }

    @Override
    public void update() {

    }

    @Override
    public void save() {
        int id = BankManagerDatabase.insert(this);
        this.setId(id);
    }
}
