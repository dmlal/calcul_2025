package calculator;

import java.util.ArrayList;
import java.util.List;

import exception.DivideByZeroException;
import exception.InvalidOperatorException;

public class Calculator {
	private final List<Double> resultList;

	public Calculator() {
		resultList = new ArrayList<>();
	}

	public Double calculate(int num1, int num2, char operator) throws InvalidOperatorException, DivideByZeroException {
		if (operator == '/' && num2 == 0) {
			throw new DivideByZeroException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
		}

		double result = switch (operator) {
			case '+' -> num1 + num2;
			case '-' -> num1 - num2;
			case '*' -> num1 * num2;
			case '/' -> (double)num1 / num2;
			default -> throw new InvalidOperatorException("잘못된 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
		};

		resultList.add(result);

		return result;
	}

	public List<Double> getResultList() {
		return new ArrayList<>(resultList);
	}

	public void setResultList(List<Double> resultList) {
		this.resultList.clear();
		this.resultList.addAll(resultList);
	}

	public void removeFirstResult() {
		if (!resultList.isEmpty()) {
			resultList.remove(0);
		}
	}

	public boolean hasResult() {
		return !resultList.isEmpty();
	}

	public void inquiryResultList() {
		if (resultList.isEmpty()) {
			System.out.println("저장한 결과가 없습니다.");
		} else {
			for (Double d : resultList) {
				System.out.println(d);
			}
		}
	}
}
