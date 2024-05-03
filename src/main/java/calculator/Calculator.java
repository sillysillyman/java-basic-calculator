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