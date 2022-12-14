package Grid.Coordinates;

import java.util.HashMap;
import java.util.Map;

public enum Row {
        R0(0),
        R1(1),
        R2(2),
        R3(3),
        R4(4),
        R5(5),
        R6(6),
        R7(7),
        R8(8),
        R9(9);

        public final Integer value;
        private static final Map<Integer, Row> map = new HashMap<>();

        Row(Integer value) {
            this.value = value;
        }

        static {
                for (Row rowName : Row.values()) {
                        map.put(rowName.value, rowName);
                }
        }

        public static Row valueOf(int value) {
                return map.get(value);
        }
}
