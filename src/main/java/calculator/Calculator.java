package calculator;

import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;

public class Calculator {

    static final double PI = Math.PI;
    protected Queue<Double> results;

    public Queue<Double> getResults() {
        return new LinkedList<>(results);
    }

    public void setResults(Queue<Double> results) {
        this.results = results;
    }

    public void removeResult() {
        if (results.poll() == null) {
            System.out.println("Results queue is empty.");
        }
    }

    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("Results queue is empty.");
        } else {
            System.out.print("results: [ ");
            results.forEach(
                element -> {
                    System.out.printf("%.2f ", element);
                });
            System.out.println("]");
        }
    }
}

class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator() {
        this.results = new LinkedList<Double>();
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

class CircleCalculator extends Calculator {

    public CircleCalculator() {
        this.results = new LinkedList<Double>();
    }

    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        if (!results.offer(area)) {
            System.out.println("Enqueue operation failed.");
        }
        return area;
    }
}