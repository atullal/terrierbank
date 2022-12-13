package Account;

public class AccountFactory {

    public Account makeAccount(AccountType accountType, int bal, String accountNo){
        switch (accountType){
            case CHECKING:
                return new CheckingAccount(bal);
            default:
                return new SavingsAccount(bal);
        }
    }

    public Account makeSecurityAccount(Account account, int bal, String accountNo){
        return new SecurityAccount(account, bal);
    }
}
