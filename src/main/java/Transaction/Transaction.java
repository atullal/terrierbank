package Transaction;

import Account.Account;
import Account.AccountDatabase;
import Database.DatabaseController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    // for deposit, sender will be self and receiver will be account no
    // for withdraw, receiver will be "cash"
    public Transaction(){
    }
    public void process(String sender, String receiver, double amt){
        // TODO Check transaction code and add code to update values
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        int id = (int)(Math.random()*(99999999-10000000+1)+10000000);
        TransactionDatabase.insert(id, date.format(now), time.format(now), sender, receiver, amt);
        System.out.println(sender+" sends "+Double.toString(amt)+" to "+receiver);
        if (receiver.equals("Cash")){
            System.out.println("Entered");
            Account send = AccountDatabase.getAccountFromNumber(Integer.parseInt(sender));
            send.setBal(send.getBal()-amt);
            send.update();
        } else if (sender.equals("Self")) {
            Account receive = AccountDatabase.getAccountFromNumber(Integer.parseInt(receiver));
            receive.setBal(receive.getBal()+amt);
            receive.update();
        }
        else {
            Account send = AccountDatabase.getAccountFromNumber(Integer.parseInt(sender));
            send.setBal(send.getBal()-amt);
            send.update();
            Account receive = AccountDatabase.getAccountFromNumber(Integer.parseInt(receiver));
            receive.setBal(receive.getBal()+amt);
            receive.update();
        }

    }
}
