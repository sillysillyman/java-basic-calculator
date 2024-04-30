package calculator;

import java.util.Queue;
import java.util.LinkedList;

public class Calculator {

    private Queue<Double> results = new LinkedList<Double>();

    public Queue<Double> getResults() {
        return new LinkedList<>(results);
    }

    public void setResults(Queue<Double> results) {
        this.results = results;
    }

    public double calculate(double x, double y, char op) {
        double result = switch (op) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            case '/' -> {
                if (y != 0) {
                    yield x / y;
                } else {
                    throw new ArithmeticException("Division by zero is undefined.");
                }
            }
            default -> {
                throw new IllegalArgumentException("Unsupported operation: " + op);
            }
        };
        if (!results.offer(result)) {
            System.out.println("Enqueue operation failed.");
        }
        return result;
    }
}