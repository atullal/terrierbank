package Backend_Files;

import Transaction.Transaction;
import Transaction.TransactionAssociated;
import Transaction.TransactionDatabase;
import User.User;

import java.util.ArrayList;
import java.util.Date;

public class BankManager implements TransactionAssociated {
    public BankManager() {
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return TransactionDatabase.getAllTransactions();
    }
}
