package calculator;

import java.util.Queue;

public class CircleCalculator extends Calculator {

    public CircleCalculator(Queue<Double> results) {
        super(results);
    }

    public double calculate(double radius) {
        double area = Math.round(PI * radius * radius * 100) / 100.0;
        if (!super.getResults().offer(area)) {
            System.out.println("Enqueue operation failed.");
        }
        return area;
    }

    @Override
    public void inquiryResults() {
        if (super.getResults().isEmpty()) {
            System.out.println("Empty queue: there is no area.");
        } else {
            System.out.println(super.getResults());
        }
    }
}
