package calculator;

import java.util.Scanner;

import exception.DivideByZeroException;
import exception.InvalidOperatorException;

public class App {
	public static void main(String[] args) {
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
		CircleCalculator circleCalculator = new CircleCalculator();

		Scanner sc = new Scanner(System.in);

		boolean continueCalculation = true;
		while (continueCalculation) {
			System.out.println("1. 사칙연산 \n2. 원 넓이 계산");

			int choice = 0;

			do {
				while (!sc.hasNextInt()) {
					System.out.println("1 또는 2를 입력해주세요.");
					sc.next();
				}
				choice = sc.nextInt();
				if (choice != 1 && choice != 2) {
					System.out.println("1 또는 2를 입력해주세요.");
				}
			} while (choice != 1 && choice != 2);

			if (choice == 1) {
				calculate(arithmeticCalculator, sc);
			} else {
				circleCalculate(circleCalculator, sc);
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
					if (arithmeticCalculator.hasResult()) {
						arithmeticCalculator.removeFirstResult();
						System.out.println("삭제되었습니다.\n");
					} else {
						System.out.println("삭제할 결과가 없습니다.\n");
					}
				} else if (selectMenu.equals("inquiry")) {
					arithmeticCalculator.inquiryResultList();
					System.out.println();
				} else if (selectMenu.equals("circle")) {
					circleCalculator.inquiryCircleList();
					System.out.println();
				} else {
					break;
				}
			}
		}
		sc.close();
	}

	private static void calculate(ArithmeticCalculator arithmeticCalculator, Scanner sc) {
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

		String operatorInput = "";
		do {
			System.out.println("사칙연산 기호를 입력하세요: ");
			operatorInput = sc.next();

			if (operatorInput.equals("+") || operatorInput.equals("-") || operatorInput.equals("*")
				|| operatorInput.equals("/") || operatorInput.equals("%")) {
				break;
			} else {
				System.out.println("잘못된 연산자입니다. +, -, *, /, % 중 하나를 입력해주세요.");
			}
		} while (true);

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

		try {
			double result = arithmeticCalculator.calculate(firstNum, secondNum, operatorInput);
			System.out.println("결과값: " + result);
			System.out.println();
		} catch (DivideByZeroException | InvalidOperatorException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	private static void circleCalculate(CircleCalculator circleCalculator, Scanner sc) {
		double radius = 0;
		do {
			System.out.println("원의 반지름을 입력하세요: ");
			while (!sc.hasNextDouble()) {
				System.out.println("숫자를 입력해주세요.");
				sc.next();
			}
			radius = sc.nextDouble();
			if (radius < 0) {
				System.out.println("0 이상의 숫자를 입력해주세요.");
			}
		} while (radius < 0);

		double result = circleCalculator.calculateCircle(radius);
		System.out.println("원 넓이: " + result);
		System.out.println();
	}

	private static String showMenu(Scanner sc) {
		String input = "";
		do {
			System.out.println("계속 계산은 y. \n종료는 n 또는 exit. \n가장 오래된 값 제거는 remove \n저장된 결과 전체 조회는 inquiry \n원 넓이 결과 조회는 circle");
			input = sc.nextLine().trim().toLowerCase();

			if (checkInputStringValue(input)) {
				System.out.println("올바른 선택지를 입력해주세요.\n");
			}
		} while (checkInputStringValue(input));

		return input;
	}

	private static boolean checkInputStringValue(String input) {
		return !input.equals("1") && !input.equals("y") && !input.equals("ㅛ")
			&& !input.equals("2") && !input.equals("n") && !input.equals("ㅜ") && !input.equals("exit")
			&& !input.equals("remove") && !input.equals("inquiry") && !input.equals("circle");
	}
}
