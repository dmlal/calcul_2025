package circle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.CircleCalculator;

public class CircleStateManageTest {

	private CircleCalculator calculator = new CircleCalculator();

	@BeforeEach
	void setUp() throws Exception {
		calculator = new CircleCalculator();
	}

	@Test
	@DisplayName("원 넓이 계산 결과 저장 확인")
	void testCalculate() {
		calculator.calculateCircle(1.1);
		calculator.calculateCircle(4.0);
		calculator.calculateCircle(5.0);

		List<Double> result = calculator.getCircleList();
		assertEquals(3, result.size());
		assertEquals(3.8013, result.get(0), 0.0001);
		assertEquals(50.26544, result.get(1), 0.0001);
		assertEquals(78.53975, result.get(2), 0.0001);
	}
}
