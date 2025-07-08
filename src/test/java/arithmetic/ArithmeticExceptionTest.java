package arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.ArithmeticCalculator;
import exception.DivideByZeroException;
import exception.InvalidOperatorException;

public class ArithmeticExceptionTest {

	private ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

	@BeforeEach
	public void setUp() {
		calculator = new ArithmeticCalculator<>();
	}

	@Test
	@DisplayName("0으로 나누기")
	void testDivideByZero() {
		assertThrows(DivideByZeroException.class, () -> calculator.calculate(1.0, 0.0, "/"));
	}

	@Test
	@DisplayName("0으로 나머지")
	void testModuloByZero() {
		assertThrows(DivideByZeroException.class, () -> calculator.calculate(1.0, 0.0, "%"));
	}

	@Test
	@DisplayName("연산자 잘못 입력")
	void testInvalidOperator() {
		assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1.0, 0.0, "!"));
		assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1.0, 0.0, "+-"));
		assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1.0, 0.0, "ㅇㅇ"));
		assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1.0, 0.0, "zz"));
	}

	@Test
	@DisplayName("예외 메세지 출력 확인")
	void testExceptionMsg() {
		DivideByZeroException de = assertThrows(DivideByZeroException.class, () -> calculator.calculate(1.0, 0.0, "/"));
		assertTrue(de.getMessage().contains("나눗셈"));

		DivideByZeroException de2 = assertThrows(DivideByZeroException.class, () -> calculator.calculate(1.0, 0.0, "%"));
		assertTrue(de2.getMessage().contains("나머지"));

		InvalidOperatorException ie = assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1.0, 0.0, "!"));
		assertTrue(ie.getMessage().contains("잘못된 연산자"));
	}

	@Test
	@DisplayName("null")
	void testNullException() {
		assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1.0, 0.0, null));
	}
}
