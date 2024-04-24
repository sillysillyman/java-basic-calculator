package calculator;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    char op;
    int x, y;
    Scanner sc = new Scanner(System.in);

    System.out.print("첫 번째 숫자를 입력하세요: ");
    x = sc.nextInt();
    System.out.print("두 번째 숫자를 입력하세요: ");
    y = sc.nextInt();
    System.out.print("사칙연산 기호를 입력하세요: ");
    op = sc.next().charAt(0);
    sc.close();
  }
}
