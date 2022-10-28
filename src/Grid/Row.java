package Grid;

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

        Row(Integer value) {
            this.value = value;
        }

        protected Integer getValue(){
                return value;
        }
}
