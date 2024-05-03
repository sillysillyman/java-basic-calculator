package calculator;

import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;

public class Calculator {

    static final double PI = Math.PI;
    protected Queue<Double> results;

    public Calculator() {
        this.results = new LinkedList<>();
    }

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
            System.out.println(results);
        }
    }
}

interface Operator {

    double operate(double x, double y);
}

class AddOperator implements Operator {

    public double operate(double x, double y) {
        return x + y;
    }
}

class SubtractOperator implements Operator {

    public double operate(double x, double y) {
        return x - y;
    }
}

class MultiplyOperator implements Operator {

    public double operate(double x, double y) {
        return x * y;
    }
}

class DivideOperator implements Operator {

    public double operate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }
        return x / y;
    }
}

class ModOperator implements Operator {

    public double operate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }
        return x % y;
    }
}