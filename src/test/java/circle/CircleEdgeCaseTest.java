package circle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.CircleCalculator;

public class CircleEdgeCaseTest {

	private CircleCalculator calculator;

	@BeforeEach
	public void setUp() {
		calculator = new CircleCalculator();
	}

	@Test
	@DisplayName("정상 동작")
	void testCalculate() {
		double result = calculator.calculateCircle(5.0);
		assertEquals(78.539, result, 0.001);
	}

	@Test
	@DisplayName("반지름 0")
	void testZeroRadius() {
		double result = calculator.calculateCircle(0.0);
		assertEquals(0.0, result);
	}

	@Test
	@DisplayName("매우 큰 반지름 - 무한대")
	void testLargeRadius() {
		double radius = Math.sqrt(Double.MAX_VALUE);
		double result = calculator.calculateCircle(radius);

		assertTrue(Double.isInfinite(result));
	}

	@Test
	@DisplayName("매우 작은 반지름")
	void testSmallRadius() {
		double radius = Math.sqrt(Double.MIN_VALUE);
		double result = calculator.calculateCircle(radius);

		assertTrue(result > 0);
	}
}
