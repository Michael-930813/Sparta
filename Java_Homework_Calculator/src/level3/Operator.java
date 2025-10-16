package level3;

public enum Operator {
    // - Enumeration
        PLUS('+'),
        MINUS('-'),
        MULTYPLE('*'),
        DIVIDE('/');

// - Variable
    private final Character symbol;


// - Function
    // - Structor
    Operator( char symbol ) {
        this.symbol = symbol;
    }
    // - get & set
    public char getSymbol() { return symbol; }

    // - Char -> Enum
    public static Operator fromChar(char c) {
        for(Operator op : Operator.values()) {
            if(op.getSymbol() == c) {
                return op;
            }
        }
        return null;
    }
}