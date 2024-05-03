package calculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ArithmeticCalculator extends Calculator {

    final private Map<Character, Operator> operators;

    public ArithmeticCalculator(Queue<Double> results) {
        super(results);
        this.operators = new HashMap<>();
        this.operators.put('+', new AddOperator());
        this.operators.put('-', new SubtractOperator());
        this.operators.put('*', new MultiplyOperator());
        this.operators.put('/', new DivideOperator());
        this.operators.put('%', new ModOperator());
    }

    public double calculate(double x, double y, char op) {
        Operator operator = operators.get(op);
        if (operator == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
        double result = Math.round(operator.operate(x, y) * 100) / 100.0;
        if (!super.getResults().offer(result)) {
            System.out.println("Enqueue operation failed.");
        }
        return result;
    }

    @Override
    public void inquiryResults() {
        if (super.getResults().isEmpty()) {
            System.out.println("Empty queue: there is no result.");
        } else {
            System.out.println(super.getResults());
        }
    }
}
