package Backend_Files;

public class Transaction {
    public void toAccount(String senderNo, String receiverNo, double amt){

    }

    public void toSelf(String accountNo, double amt){

    }

    public static void insert(Account account) {
        String statement = "INSERT INTO ACCOUNT (ACCOUNTNUM,USERID,ACCOUNTTYPE,BALANCE) " +
                "VALUES ("+account.getAccountNumber()+", "+account.getCustomer().getId()+", '"+account.getAccountType()+"', "+account.getBal()+");";
        DatabaseController.getInstance().updateStatement(statement);
    }
}
