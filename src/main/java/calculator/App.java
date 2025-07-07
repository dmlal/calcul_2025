package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력하세요: ");
        int firstNum = sc.nextInt();

        System.out.println("두 번째 숫자를 입력하세요: ");
        int secondNum = sc.nextInt();

        System.out.println("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        System.out.println("첫 번째 숫자: " + firstNum);
        System.out.println("두 번째 숫자: " + secondNum);
        System.out.println("연산자: " + operator);
    }
}
