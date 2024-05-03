package calculator;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticCalculator extends Calculator {

    final private Map<Character, Operator> operators;

    public ArithmeticCalculator() {
        super();
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
        if (!results.offer(result)) {
            System.out.println("Enqueue operation failed.");
        }
        return result;
    }
}
