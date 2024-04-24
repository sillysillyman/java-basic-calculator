package calculator;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    char op;
    int x, y;
    double result;
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the first number: ");
    x = sc.nextInt();
    System.out.print("Enter the second number: ");
    y = sc.nextInt();
    System.out.print("Enter the operator: ");
    op = sc.next().charAt(0);
    result =
      switch (op) {
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
    sc.close();
  }
}
