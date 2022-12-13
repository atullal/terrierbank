package Transaction;

import Account.Account;
import Database.DatabaseController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    // for deposit, sender and receiver account no will be same
    // for withdraw, receiver will be "cash"
    public void process(String sender, String receiver, double amt){
        // TODO Check transaction code and add code to update values
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        int id = (int)(Math.random()*(99999999-10000000+1)+10000000);
        TransactionDatabase.insert(id, date.format(now), time.format(now), sender, receiver, amt);
    }
}
