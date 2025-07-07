package calculator;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator extends Calculator<Double> {
	private static final double PI = 3.14159;
	private final List<Double> circleList;

	public CircleCalculator() {
		circleList = new ArrayList<>();
	}

	public double calculateCircle(double radius) {
		double result = PI * radius * radius;
		circleList.add(result);
		return result;
	}

	public List<Double> getCircleList() {
		return new ArrayList<>(circleList);
	}

	public void setCircleList(List<Double> circleList) {
		this.circleList.clear();
		this.circleList.addAll(circleList);
	}

	public void inquiryCircleList() {
		if (circleList.isEmpty()) {
			System.out.println("저장한 결과가 없습니다.");
		} else  {
			for (Double d : circleList) {
				System.out.println(d);
			}
		}
	}
}
