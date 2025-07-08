package arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.ArithmeticCalculator;

public class ArithmeticFunctionTest {

	private ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

	@BeforeEach
	public void setUp() {
		calculator = new ArithmeticCalculator<>();
	}

	@Test
	@DisplayName("+")
	void testAdd() throws Exception {
		assertEquals(10.0, calculator.calculate(1.0, 9.0,"+"));

		// app 에서는 음수를 못받도록 되어 있으나 calculator에는 제약사항이 없으므로 가능함
		assertEquals(10.0, calculator.calculate(-1.0, 11.0,"+"));
		assertEquals(10.0, calculator.calculate(1.05, 8.95,"+"));
	}

	@Test
	@DisplayName("-")
	void testSubtract() throws Exception {
		assertEquals(10.0, calculator.calculate(19.0, 9.0,"-"));
		assertEquals(-10.0, calculator.calculate(-9.0, 1.0,"-"));
		assertEquals(-10.0, calculator.calculate(9.0, 19.0,"-"));
	}

	@Test
	@DisplayName("*")
	void testMultiply() throws Exception {
		assertEquals(10.0, calculator.calculate(1.0, 10.0,"*"));
		assertEquals(-10.0, calculator.calculate(-1.0, 10.0,"*"));
		assertEquals(-10.0, calculator.calculate(1.0, -10.0,"*"));
		assertEquals(10.0, calculator.calculate(-1.0, -10.0,"*"));


		assertEquals(2.42, calculator.calculate(-1.1, -2.2,"*"), 0.001);
		assertEquals(2.42, calculator.calculate(1.1, 2.2,"*"), 0.001);
		assertEquals(-2.42, calculator.calculate(1.1, -2.2,"*"),	0.001);
		assertEquals(-2.42, calculator.calculate(-1.1, 2.2,"*"), 0.001);
	}

	@Test
	@DisplayName("/")
	void testDivide() throws Exception {
		assertEquals(0.1, calculator.calculate(1.0, 10.0,"/"));
		assertEquals(-0.1, calculator.calculate(-1.0, 10.0,"/"));
		assertEquals(-0.1, calculator.calculate(1.0, -10.0,"/"));
		assertEquals(0.1, calculator.calculate(-1.0, -10.0,"/"));


		assertEquals(0.5, calculator.calculate(-1.1, -2.2,"/"), 0.001);
		assertEquals(0.5, calculator.calculate(1.1, 2.2,"/"), 0.001);
		assertEquals(-0.5, calculator.calculate(1.1, -2.2,"/"),	0.001);
		assertEquals(-0.5, calculator.calculate(-1.1, 2.2,"/"), 0.001);
	}

	@Test
	@DisplayName("%")
	void testModulo() throws Exception {
		assertEquals(0.0, calculator.calculate(100.0, 10.0,"%"));
		assertEquals(1.0, calculator.calculate(1.0, 10.0,"%"));
		assertEquals(1.5, calculator.calculate(5.5, 2.0,"%"));
	}


}
