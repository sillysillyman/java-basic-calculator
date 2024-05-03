package calculator;

public class CircleCalculator extends Calculator {

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
