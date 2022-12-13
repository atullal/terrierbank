package Loan;

import java.util.HashMap;
import java.util.Map;

/** Enum of all the account types
 */
public enum LoanStatus {
    SUBMITTED("Submitted"),
    APPROVED("Approved"),
    DENIED("Denied"),
    PAID("Paid");

    private final String text;

    private static final Map<String, LoanStatus> map = new HashMap<>(values().length, 1);

    static {
        for (LoanStatus c : values()) map.put(c.toString(), c);
    }

    LoanStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


    public static LoanStatus of(String id) throws IllegalArgumentException {
        LoanStatus result = map.get(id);
        if (result == null) {
            throw new IllegalArgumentException("Invalid account type: " + id);
        }
        return result;
    }

}

