package calculator;

class SubtractOperator implements Operator {

    @Override
    public double operate(double x, double y) {
        return x - y;
    }
}