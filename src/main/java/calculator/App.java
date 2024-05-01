package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

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

                    System.out.print("Enter the operator (+, -, *, /): ");
                    char op = sc.nextLine().charAt(0);
                    double result = calc.calculate(x, y, op);
                    System.out.println("result: " + result);
                    System.out.println(
                        "Do you want to remove the oldest result? (Press ENTER to continue, type 'remove' to delete it)");
                    String removeMsg = sc.nextLine();
                    if (removeMsg.strip().equalsIgnoreCase("remove")) {
                        calc.removeResult();
                    }
                    System.out.println(
                        "Do you want to inquiry the saved results? (Press ENTER to continue, type 'inquiry' to check them)");
                    String inquiryMsg = sc.nextLine();
                    if (inquiryMsg.strip().equalsIgnoreCase("inquiry")) {
                        calc.inquiryResults();
                    }
                }
                case 2 -> {
                    System.out.print("Enter the radius: ");
                    double radius = Double.parseDouble(sc.nextLine());
                    double area = calc.calculateCircleArea(radius);
                    if (calc.getAreas().isEmpty()) {
                        System.out.println("Results queue is empty.");
                    } else {
                        System.out.print("results: [ ");
                        calc.getAreas().forEach(
                            element -> {
                                System.out.printf("%.2f ", element);
                            });
                        System.out.println("]");
                    }
                }
                default -> {
                    throw new IllegalArgumentException("Unsupported option: " + choice);
                }
            }
            System.out.println(
                "Do you want to calculate more? (Press ENTER to continue, type 'exit' to end)");
            String exitMsg = sc.nextLine();
            if (exitMsg.strip().equalsIgnoreCase("exit")) {
                break;
            }
        }
        sc.close();
    }
}
