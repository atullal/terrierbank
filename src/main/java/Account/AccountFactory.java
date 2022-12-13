package Account;

import Backend_Files.Customer;

public class AccountFactory {

    public Account makeAccount(Customer customer, AccountType accountType, int bal, String accountNo){
        switch (accountType){
            case CHECKING:
                return new CheckingAccount(customer, bal, accountNo);
            default:
                return new SavingsAccount(customer, bal, accountNo);
        }
    }

    public Account makeSecurityAccount(Customer customer, Account account, int bal, String accountNo){
        return new SecurityAccount(customer, account, bal, accountNo);
    }
}
