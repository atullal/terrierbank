package Transaction;

import Account.Account;
import Account.AccountDatabase;
import Database.DatabaseController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    // for deposit, sender will be self and receiver will be account no
    // for withdraw, receiver will be "cash"
    private Account sender;
    private Account receiver;
    private double amount;
    private TransactionType type;
    private int id;
    private String date;
    private String time;
    public Transaction(Account sender, Account receiver, double amt, TransactionType type){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amt;
        this.type = type;
    }

    public Transaction(Account sender, Account receiver, double amt, TransactionType type, int id, String date, String time){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amt;
        this.type = type;
        this.id = id;
        this.date = date;
        this.time = time;
    }
//    public void process(String sender, String receiver, double amt){
//        // TODO Check transaction code and add code to update values
//        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
//        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDateTime now = LocalDateTime.now();
//        int id = (int)(Math.random()*(99999999-10000000+1)+10000000);
//        TransactionDatabase.insert(id, date.format(now), time.format(now), sender, receiver, amt);
//        System.out.println(sender+" sends "+Double.toString(amt)+" to "+receiver);
//        if (receiver.equals("Cash")){
//            System.out.println("Entered");
//            Account send = AccountDatabase.getAccountFromNumber(Integer.parseInt(sender));
//            send.setBal(send.getBal()-amt);
//            send.update();
//        } else if (sender.equals("Self")) {
//            Account receive = AccountDatabase.getAccountFromNumber(Integer.parseInt(receiver));
//            receive.setBal(receive.getBal()+amt);
//            receive.update();
//        }
//        else {
//            Account send = AccountDatabase.getAccountFromNumber(Integer.parseInt(sender));
//            send.setBal(send.getBal()-amt);
//            send.update();
//            Account receive = AccountDatabase.getAccountFromNumber(Integer.parseInt(receiver));
//            receive.setBal(receive.getBal()+amt);
//            receive.update();
//        }
//    }

    public void process(){
        // TODO Check transaction code and add code to update values
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        int id = (int)(Math.random()*(99999999-10000000+1)+10000000);
        this.id = id;
        this.date = date.format(now);
        this.time = time.format(now);

        switch (type) {
            case WITHDRAW:
                System.out.println("Withdrawing from " + sender.getAccountNumber());
                TransactionDatabase.insert(id, date.format(now), time.format(now), String.valueOf(sender.getAccountNumber()), "Cash", amount);
                sender.setBal(sender.getBal()-amount);
                sender.update();
                break;
            case DEPOSIT:
                System.out.println("Depositing to " + receiver.getAccountNumber());
                TransactionDatabase.insert(id, date.format(now), time.format(now),"Self", String.valueOf(receiver.getAccountNumber()), amount);
                receiver.setBal(receiver.getBal()+amount);
                receiver.update();
                break;
            case TRANSFER:
                System.out.println("Transfer from " + sender.getAccountNumber()+" to " + receiver.getAccountNumber());
                TransactionDatabase.insert(id, date.format(now), time.format(now),String.valueOf(sender.getAccountNumber()), String.valueOf(receiver.getAccountNumber()), amount);
                sender.setBal(sender.getBal()-amount);
                sender.update();
                receiver.setBal(receiver.getBal()+amount);
                receiver.update();
                break;
        }
    }
}
