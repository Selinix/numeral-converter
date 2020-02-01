package converter;

public enum Romans {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int arabicValue;

    private Romans(int arabicValue) {
        this.arabicValue = arabicValue;
    }

    public int getArabicValue() {
        return arabicValue;
    }
}
