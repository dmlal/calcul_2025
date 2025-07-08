package circle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.CircleCalculator;

public class CircleFunctionTest {

	private CircleCalculator calculator = new CircleCalculator();

	@BeforeEach
	void setUp() {
		calculator = new CircleCalculator();
	}

	@Test
	@DisplayName("원 넓이 계산")
	void testCalculate() {
		assertEquals(0.0, calculator.calculateCircle(0), 0.0001);
		assertEquals(Math.PI, calculator.calculateCircle(1.0), 0.0001);
		assertEquals(Math.PI * 25.0, calculator.calculateCircle(5.0), 0.0001);
		assertEquals(Math.PI * 6.25, calculator.calculateCircle(2.5), 0.0001);
	}
}
