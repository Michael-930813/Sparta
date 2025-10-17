package level3;

import java.util.Arrays;

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
        return Arrays.stream(values())
                .filter(operator -> operator.symbol == c)
                .findFirst()
                .orElse(null);
    }
}