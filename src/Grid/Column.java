package Grid;

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

    private final Integer value;

    Column(Integer value) {
        this.value = value;
    }
    protected Integer getValue(){
        return value;
    }
}
