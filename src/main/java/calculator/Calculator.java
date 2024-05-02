package calculator;

import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Calculator {

    static final double PI = Math.PI;
    protected Queue<Double> results;

    public Calculator() {
        this.results = new LinkedList<Double>();
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
            System.out.println(results.toString());
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


class ArithmeticCalculator extends Calculator {

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
            throw new IllegalArgumentException("Unsupported operation: " + op);
        }
        double result = Math.round(operator.operate(x, y) * 100) / 100.0;
        if (!results.offer(result)) {
            System.out.println("Enqueue operation failed.");
        }
        return result;
    }
}

class CircleCalculator extends Calculator {

    public CircleCalculator() {
        super();
    }

    public double calculateCircleArea(double radius) {
        double area = Math.round(PI * radius * radius * 100) / 100.0;
        if (!results.offer(area)) {
            System.out.println("Enqueue operation failed.");
        }
        return area;
    }
}