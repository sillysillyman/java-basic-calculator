package calculator;

public enum OperatorType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    MODULO('%');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType charToOperator(char op) {
        for (var type : OperatorType.values()) {
            if (type.symbol == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unsupported operation: " + op);
    }
}
