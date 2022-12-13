package Loan;

import java.util.HashMap;
import java.util.Map;

/** Enum of all the account types
 */
public enum LoanType {
    CAR("Car loan"),
    EDUCATION("Education loan"),
    HOME("Home loan"),
    PERSONAL("Personal loan");

    private final String text;

    private static final Map<String, LoanType> map = new HashMap<>(values().length, 1);

    static {
        for (LoanType c : values()) map.put(c.toString(), c);
    }

    LoanType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


    public static LoanType of(String id) throws IllegalArgumentException {
        LoanType result = map.get(id);
        if (result == null) {
            throw new IllegalArgumentException("Invalid loan type: " + id);
        }
        return result;
    }

}

