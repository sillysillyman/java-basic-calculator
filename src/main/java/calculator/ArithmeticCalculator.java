package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(Queue<Double> results) {
        super(results);
    }

    public double calculate(double x, double y, char op) {
        double result = Math.round(selectOperator(op).operate(x, y) * 100) / 100.0;
        if (!super.getResults().offer(result)) {
            System.out.println("Enqueue operation failed.");
        }
        return result;
    }

    private Operator selectOperator(char op) {
        OperatorType opType = OperatorType.charToOperator(op);
        return switch (opType) {
            case ADDITION -> new AddOperator();
            case SUBTRACTION -> new SubtractOperator();
            case MULTIPLICATION -> new MultiplyOperator();
            case DIVISION -> new DivideOperator();
            case MODULO -> new ModOperator();
        };
    }

    public void inquiryGreaterThan(double x) {
        Queue<Double> filteredResults = super.getResults().stream()
            .filter(value -> value > x)
            .collect(Collectors.toCollection(LinkedList::new));
        if (filteredResults.isEmpty()) {
            System.out.println("Empty queue: there is no result.");
        } else {
            System.out.println(filteredResults);
        }
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
