package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.DivideByZeroException;
import exception.InvalidOperatorException;
import operator.AddOperator;
import operator.DivideOperator;
import operator.ModOperator;
import operator.MultiplyOperator;
import operator.Operator;
import operator.SubtractOperator;

public class ArithmeticCalculator extends Calculator {
	private final List<Double> resultList;

	private final Map<String, Operator> operatorMap;

	public ArithmeticCalculator() {
		resultList = new ArrayList<>();
		operatorMap = new HashMap<>();

		operatorMap.put("+", new AddOperator());
		operatorMap.put("-", new SubtractOperator());
		operatorMap.put("*", new MultiplyOperator());
		operatorMap.put("/", new DivideOperator());
		operatorMap.put("%", new ModOperator());
	}

	public Double calculate(int num1, int num2, String operator) throws
		InvalidOperatorException,
		DivideByZeroException {
		if (operator.equals("/") && num2 == 0) {
			throw new DivideByZeroException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
		}

		if (operator.equals("%") && num2 == 0) {
			throw new DivideByZeroException("나머지 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
		}

		Operator opr = operatorMap.get(operator);
		if (opr == null) {
			throw new InvalidOperatorException("잘못된 연산자입니다. +, -, *, /, % 중 하나를 입력해주세요.");
		}
		double result = opr.operate(num1, num2);
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
