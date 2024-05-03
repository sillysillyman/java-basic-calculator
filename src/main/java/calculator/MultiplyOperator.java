package calculator;

public class MultiplyOperator implements Operator {

    @Override
    public double operate(double x, double y) {
        return x * y;
    }
}
