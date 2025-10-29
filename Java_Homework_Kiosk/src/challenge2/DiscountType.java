package challenge2;

public enum DiscountType {
// - Property
    VETERAN(0.10f, "국가유공자 : 10%"),
    SOLDIER(0.05f, "군인 : 5%"),
    STUDENT(0.03f, "학생 : 3%"),
    NORMAL(0.0f, "일반 : 0%");

    private final float rate;
    private final String label;


// - Method
    // - Structor
    DiscountType(float rate, String label) {
        this.rate = rate;
        this.label = label;
    }
    // - Get & Set
    public float getRate() { return rate; }
    public String getLabel() { return label; }

    // - Enum fron Int
    public static DiscountType fromInt(int index) {
        return switch (index) {
            case 1 -> VETERAN;
            case 2 -> SOLDIER;
            case 3 -> STUDENT;
            default -> NORMAL;
        };
    }
}
