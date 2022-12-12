package Account;

import java.util.HashMap;
import java.util.Map;

/** Enum of all the account types
 */
public enum AccountType {
    CHECKING("Checking"),
    SAVINGS("Savings"),
    SECURITY("Security");

    private final String text;

    private static final Map<String, AccountType> map = new HashMap<>(values().length, 1);

    static {
        for (AccountType c : values()) map.put(c.toString(), c);
    }

    AccountType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


    public static AccountType of(String id) throws IllegalArgumentException {
        AccountType result = map.get(id);
        if (result == null) {
            throw new IllegalArgumentException("Invalid account type: " + id);
        }
        return result;
    }

}

