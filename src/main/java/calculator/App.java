package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

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

            double result = calc.calculate(x, y, op);
            System.out.println("result: " + result);
            System.out.println(
                "Do you want to remove the oldest result? (Press ENTER to continue, type 'remove' to delete it)");
            String removeMsg = sc.nextLine();
            if (removeMsg.strip().equalsIgnoreCase("remove")) {
                if (calc.queue.poll() == null) {
                    System.out.println("Queue is empty.");
                }
            }
            System.out.println(
                "Do you want to inquiry the saved results? (Press ENTER to continue, type 'inquiry' to check them)");
            String inquiryMsg = sc.nextLine();
            if (inquiryMsg.strip().equalsIgnoreCase("inquiry")) {
                if (calc.queue.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    System.out.print("Queue: [ ");
                    calc.queue.forEach(
                        element -> {
                            System.out.printf("%.2f ", element);
                        });
                    System.out.println("]");
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
