package Loan;

import java.util.HashMap;
import java.util.Map;

/** Enum of all the account types
 */
public enum CollateralType {
    CAR("Car"),
    GOLD("Gold"),
    PROPERTY("Property"),
    NOCOLLATERAL("No collateral");

    private final String text;

    private static final Map<String, CollateralType> map = new HashMap<>(values().length, 1);

    static {
        for (CollateralType c : values()) map.put(c.toString(), c);
    }

    CollateralType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


    public static CollateralType of(String id) throws IllegalArgumentException {
        CollateralType result = map.get(id);
        if (result == null) {
            throw new IllegalArgumentException("Invalid account type: " + id);
        }
        return result;
    }

}

