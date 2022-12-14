package Grid.Coordinates;

import java.util.HashMap;
import java.util.Map;

public enum Column {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7),
    I(8),
    J(9);

    public final Integer value;
    private static final Map<Integer, Column> map = new HashMap<>();

    Column(Integer value) {
        this.value = value;
    }

    static {
        for (Column columnName : Column.values()) {
            map.put(columnName.value, columnName);
        }
    }

    public static Column valueOf(int value) {
        return map.get(value);
    }
}
