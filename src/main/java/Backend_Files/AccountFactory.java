package Backend_Files;

public class AccountFactory {

    public Account makeAccount(String accountType, int bal){
        switch (accountType){
            case "Checking":
                return new CheckingAccount(bal);
            default:
                return new SavingsAccount(bal);
        }
    }

    public Account makeAccount(String accountType, Account account, int bal){
        return new SecurityAccount(account, bal);
    }
}
