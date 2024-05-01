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

class AddOperator {

    public double operate(double x, double y) {
        return x + y;
    }
}

class SubtractOperator {

    public double operate(double x, double y) {
        return x - y;
    }
}

class MultiplyOperator {

    public double operate(double x, double y) {
        return x * y;
    }
}

class DivideOperator {

    public double operate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }
        return x / y;
    }
}


class ArithmeticCalculator extends Calculator {

    private AddOperator addOperator;
    private SubtractOperator subtractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;

    public ArithmeticCalculator() {
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
        this.results = new LinkedList<Double>();
    }

    public double calculate(double x, double y, char op) {
        double result = switch (op) {
            case '+' -> addOperator.operate(x, y);
            case '-' -> subtractOperator.operate(x, y);
            case '*' -> multiplyOperator.operate(x, y);
            case '/' -> divideOperator.operate(x, y);
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