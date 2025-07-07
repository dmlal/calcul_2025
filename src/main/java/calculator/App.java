package calculator;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int firstNum = 0;
			do {
				System.out.println("첫 번째 숫자를 입력하세요: ");
				while (!sc.hasNextInt()) {
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
				while (!sc.hasNextInt()) {
					System.out.println("숫자를 입력해주세요.");
					sc.next();
				}
				secondNum = sc.nextInt();
				if (secondNum < 0) {
					System.out.println("0 이상의 숫자를 입력해주세요.");
				}
			} while (secondNum < 0);

			char operator = ' ';

			do {
				System.out.println("사칙연산 기호를 입력하세요: ");
				operator = sc.next().charAt(0);

				if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
					System.out.println("잘못된 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
				}
			} while (operator != '+' && operator != '-' && operator != '/');

			if (operator == '/' && secondNum == 0) {
				System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
				continue;
			}

			int result = switch (operator) {
					case '+' -> firstNum + secondNum;
					case '-' -> firstNum - secondNum;
					case '*' -> firstNum * secondNum;
					case '/' -> firstNum / secondNum;
					default -> 0;
			};
			System.out.println("결과값: " + result);

			System.out.println("더 계산하시겠습니까? 계속 하시려면 아무 값이나 입력해주세요. (exit 입력 시 종료)");
			sc.nextLine();
			String input = sc.nextLine();
			if (input.equals("exit")) {
				System.out.println("계산을 종료합니다.");
				break;
			}

		}
		sc.close();
	}
}
