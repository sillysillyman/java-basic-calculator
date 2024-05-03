package calculator;

public class DivideOperator implements Operator {

    @Override
    public double operate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }
        return x / y;
    }
}