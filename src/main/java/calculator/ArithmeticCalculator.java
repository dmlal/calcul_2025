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
import operator.enums.OperatorType;

public class ArithmeticCalculator<T extends Number> extends Calculator {
	private final List<Double> resultList;

	private final Map<OperatorType, Operator> operatorMap;

	public ArithmeticCalculator() {
		resultList = new ArrayList<>();
		operatorMap = new HashMap<>();

		operatorMap.put(OperatorType.ADD, new AddOperator());
		operatorMap.put(OperatorType.SUBTRACT, new SubtractOperator());
		operatorMap.put(OperatorType.MULTIPLY, new MultiplyOperator());
		operatorMap.put(OperatorType.DIVIDE, new DivideOperator());
		operatorMap.put(OperatorType.MODULO, new ModOperator());
	}

	public Double calculate(T num1, T num2, String operatorSymbol) throws InvalidOperatorException, DivideByZeroException {
		OperatorType oprType = OperatorType.fromSymbol(operatorSymbol);
		if (oprType == null) {
			throw new InvalidOperatorException("잘못된 연산자입니다. +, -, *, /, % 중 하나를 입력해주세요.");
		}

		if ((oprType == OperatorType.DIVIDE || oprType == OperatorType.MODULO) && num2.doubleValue() == 0) {
			String msg = oprType == OperatorType.DIVIDE ? "나눗셈" : "나머지";
			throw new DivideByZeroException(msg + " 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
		}

		Operator opr = operatorMap.get(oprType);
		double result = opr.operate(num1.doubleValue(), num2.doubleValue());
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
