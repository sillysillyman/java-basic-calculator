package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalc = new ArithmeticCalculator();
        CircleCalculator circleCalc = new CircleCalculator();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Arithmetic Operation");
            System.out.println("2. Calculate Circle Area");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    double x = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the first number: ");
                            x = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }

                    double y = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the second number: ");
                            y = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }

                    System.out.print("Enter the operator (+, -, *, /, %): ");
                    char op = sc.nextLine().charAt(0);
                    double result = arithmeticCalc.calculate(x, y, op);
                    System.out.println("result: " + result);
                    System.out.println(
                        "Do you want to remove the oldest result? (Press ENTER to continue, type 'remove' to delete it)");
                    if (sc.nextLine().strip().equalsIgnoreCase("remove")) {
                        arithmeticCalc.removeResult();
                    }
                    System.out.println(
                        "Do you want to inquiry the saved results? (Press ENTER to continue, type 'inquiry' to check them)");
                    if (sc.nextLine().strip().equalsIgnoreCase("inquiry")) {
                        arithmeticCalc.inquiryResults();
                    }
                }
                case 2 -> {
                    System.out.print("Enter the radius: ");
                    double radius = Double.parseDouble(sc.nextLine());
                    double area = circleCalc.calculateCircleArea(radius);
                    circleCalc.inquiryResults();
                }
                default -> {
                    throw new IllegalArgumentException("Unsupported option: " + choice);
                }
            }
            System.out.println(
                "Do you want to calculate more? (Press ENTER to continue, type 'exit' to end)");
            if (sc.nextLine().strip().equalsIgnoreCase("exit")) {
                break;
            }
        }
        sc.close();
    }
}
