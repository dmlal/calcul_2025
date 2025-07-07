package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNum = 0;
        do {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            while (!sc.hasNextInt()){
                System.out.println("숫자를 입력해주세요.");
                sc.next();
            }
            firstNum = sc.nextInt();
            if (firstNum < 0) {
                System.out.println("0 이상의 숫자를 입력해주세요.");
            }
        } while (firstNum < 0);

        int secondNum = 0;
        do {
            System.out.println("두 번째 숫자를 입력하세요: ");
            while (!sc.hasNextInt()){
                System.out.println("숫자를 입력해주세요.");
                sc.next();
            }
            secondNum = sc.nextInt();
            if (secondNum < 0) {
                System.out.println("0 이상의 숫자를 입력해주세요.");
            }
        } while (secondNum < 0);


        System.out.println("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        System.out.println("첫 번째 숫자: " + firstNum);
        System.out.println("두 번째 숫자: " + secondNum);
        System.out.println("연산자: " + operator);

        sc.close();
    }
}
