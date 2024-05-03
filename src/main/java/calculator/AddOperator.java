package calculator;

public class AddOperator implements Operator {

    @Override
    public double operate(double x, double y) {
        return x + y;
    }
}