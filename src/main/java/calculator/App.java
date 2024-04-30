package calculator;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Double> queue = new LinkedList<>();

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
            if (!queue.offer(result)) {
                System.out.println("Enqueue operation failed");
            }
            System.out.println(
                "Do you want to remove the oldest result? (type 'remove' to delete it)");
            String removeMsg = sc.nextLine();
            if (removeMsg.strip().equalsIgnoreCase("remove")) {
                if (queue.poll() == null) {
                    System.out.println("Queue is empty");
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
