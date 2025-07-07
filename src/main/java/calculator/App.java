package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.DivideByZeroException;
import exception.InvalidOperatorException;

public class App {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		Scanner sc = new Scanner(System.in);

		boolean continueCalculation = true;
		while (continueCalculation) {
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
			} while (operator != '+' && operator != '-' && operator != '*' && operator != '/');

			try {
				double result = calculator.calculate(firstNum, secondNum, operator);
				System.out.println("결과값: " + result);
				System.out.println();
			} catch (DivideByZeroException | InvalidOperatorException e) {
				System.out.println(e.getMessage());
				continue;
			}

			sc.nextLine();
			while (true) {
				String selectMenu = showMenu(sc);

				if (selectMenu.equals("exit") || selectMenu.equals("2") || selectMenu.equals("n") || selectMenu.equals(
					"ㅜ")) {
					System.out.println("계산을 종료합니다.\n");
					continueCalculation = false;
					break;
				} else if (selectMenu.equals("remove")) {
					if (calculator.hasResult()) {
						calculator.removeFirstResult();
						System.out.println("삭제되었습니다.\n");
					} else {
						System.out.println("삭제할 결과가 없습니다.\n");
					}
				} else if (selectMenu.equals("inquiry")) {
					calculator.inquiryResultList();
					System.out.println();
				} else {
					break;
				}
			}
		}
		sc.close();
	}

	private static String showMenu(Scanner sc) {
		String input = "";
		do {
			System.out.println("계속 계산은 y. \n종료는 n 또는 exit. \n가장 오래된 값 제거는 remove \n저장된 결과 전체 조회는 inquiry");
			input = sc.nextLine().trim().toLowerCase();

			if (!input.equals("1") && !input.equals("y") && !input.equals("ㅛ")
				&& !input.equals("2") && !input.equals("n") && !input.equals("ㅜ") && !input.equals("exit")
				&& !input.equals("remove") && !input.equals("inquiry")) {
				System.out.println("올바른 선택지를 입력해주세요.\n");
			}
		} while (!input.equals("1") && !input.equals("y") && !input.equals("ㅛ")
			&& !input.equals("2") && !input.equals("n") && !input.equals("ㅜ") && !input.equals("exit")
			&& !input.equals("remove") && !input.equals("inquiry"));

		return input;
	}
}
