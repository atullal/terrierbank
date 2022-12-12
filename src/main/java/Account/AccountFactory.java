package Account;

public class AccountFactory {

    public Account makeAccount(AccountType accountType, int bal){
        switch (accountType){
            case CHECKING:
                return new CheckingAccount(bal);
            default:
                return new SavingsAccount(bal);
        }
    }

    public Account makeAccount(String accountType, Account account, int bal){
        return new SecurityAccount(account, bal);
    }
}
