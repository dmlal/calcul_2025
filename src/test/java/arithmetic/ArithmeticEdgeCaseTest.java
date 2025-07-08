package arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.ArithmeticCalculator;

class ArithmeticEdgeCaseTest {

	private ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

	@BeforeEach
	void setUp() {
		calculator = new ArithmeticCalculator<>();
	}


	@Test
	@DisplayName("0.1 + 0.2 != 0.3   부동소수점 테스트")
	void testFloatingPoint() throws Exception {
		Double result = calculator.calculate(0.1, 0.2, "+");

		assertNotEquals(0.3, result);
		assertEquals(0.3,result, 0.000001);
	}

	@Test
	@DisplayName("큰 수 연산은 무한대가 되는지")
	void testLargeNum() throws Exception {
		double max = Double.MAX_VALUE;

		Double result = calculator.calculate(max, max, "+");
		assertTrue(Double.isInfinite(result));
	}

	@Test
	@DisplayName("음수 나머지 연산")
	void testNegativeModulo() throws Exception {
		assertEquals(2.0, calculator.calculate(12.0, -5.0, "%"));
		assertEquals(-2.0, calculator.calculate(-12.0, 5.0, "%"));
	}

	@Test
	@DisplayName("실수 나머지 연산")
	void testDoubleModulo() throws Exception {
		assertEquals(1.5, calculator.calculate(5.5, 2.0, "%"));
	}

	@Test
	@DisplayName("NaN")
	void testNaN() throws Exception {
		double nan = Double.NaN;

		assertTrue(Double.isNaN(calculator.calculate(nan, 5.0, "+")));
		assertTrue(Double.isNaN(calculator.calculate(5.0, nan, "*")));
	}
}
