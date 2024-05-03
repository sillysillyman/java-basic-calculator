package calculator;

import java.lang.Math;
import java.util.Queue;

public abstract class Calculator {

    public static final double PI = Math.PI;
    protected Queue<Double> results;

    public Calculator(Queue<Double> results) {
        this.results = results;
    }

    public Queue<Double> getResults() {
        return results;
    }

    public void removeResult() {
        if (results.poll() == null) {
            System.out.println("Empty queue: cannot remove anything.");
        }
    }

    abstract void inquiryResults();
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