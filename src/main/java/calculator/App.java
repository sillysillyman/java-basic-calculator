package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
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

            char op = ' ';
            while (true) {
                System.out.print("Enter the operator (+, -, *, /): ");
                op = sc.nextLine().charAt(0);

                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    break;
                } else {
                    System.out.println("Invalid operator. Please enter a valid operator.");
                }
            }

            double result = switch (op) {
                case '+' -> x + y;
                case '-' -> x - y;
                case '*' -> x * y;
                case '/' -> {
                    if (y != 0) {
                        yield (double) x / y;
                    } else {
                        System.out.println("Division by zero is undefined.");
                        yield Double.NaN;
                    }
                }
                default -> {
                    System.out.println(op + " is not an operator.");
                    yield Double.NaN;
                }
            };
            System.out.println("result: " + result);
            System.out.println(
                "Do you want to calculate more? (Press ENTER to continue, type 'exit' to end)");

            String input = sc.nextLine();
            if (input.strip().equalsIgnoreCase("exit")) {
                break;
            }
        }
        sc.close();
    }
}
