package calculator;

public class ModOperator implements Operator {

    public double operate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }
        return x % y;
    }
}