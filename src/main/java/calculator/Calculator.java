package calculator;

import java.util.Queue;
import java.util.LinkedList;

public class Calculator {

    Queue<Double> queue = new LinkedList<Double>();

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
        if (!queue.offer(result)) {
            System.out.println("Enqueue operation failed.");
        }
        return result;
    }
}