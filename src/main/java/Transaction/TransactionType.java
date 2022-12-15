package Transaction;

import java.util.HashMap;
import java.util.Map;

/** Enum of all the account types
 */
public enum TransactionType {
    WITHDRAW("Withdraw"),
    DEPOSIT("Deposit"),
    TRANSFER("Transfer"),
    FEE("Fee");

    private final String text;

    private static final Map<String, TransactionType> map = new HashMap<>(values().length, 1);

    static {
        for (TransactionType c : values()) map.put(c.toString(), c);
    }

    TransactionType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


    public static TransactionType of(String id) throws IllegalArgumentException {
        TransactionType result = map.get(id);
        if (result == null) {
            throw new IllegalArgumentException("Invalid account type: " + id);
        }
        return result;
    }

}

