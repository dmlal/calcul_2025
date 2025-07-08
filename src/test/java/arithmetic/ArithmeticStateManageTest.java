package arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.ArithmeticCalculator;

public class ArithmeticStateManageTest {

	private ArithmeticCalculator<Double> calculator = new ArithmeticCalculator();

	@BeforeEach
	public void setUp() {
		calculator = new ArithmeticCalculator();
	}

	@Test
	@DisplayName("결과 리스트 저장 확인")
	void testResultSave() throws Exception {
		calculator.calculate(10.0, 5.0, "+");
		calculator.calculate(20.0, 8.0, "+");
		calculator.calculate(30.0, 9.0, "+");

		List<Double> result = calculator.getResultList();
		assertEquals(3, result.size());
		assertEquals(15.0, result.get(0));
		assertEquals(28.0, result.get(1));
		assertEquals(39.0, result.get(2));
	}

	@Test
	@DisplayName("결과 삭제")
	void testRemoveResult() throws Exception {
		calculator.calculate(10.0, 5.0, "+");
		calculator.calculate(11.0, 5.0, "+");
		calculator.calculate(12.0, 5.0, "+");

		calculator.removeFirstResult();

		List<Double> result = calculator.getResultList();
		assertEquals(2, result.size());
		assertEquals(16.0, result.get(0));
		assertEquals(17.0, result.get(1));
	}

	@Test
	@DisplayName("빈 리스트에서 삭제 시")
	void testRemoveEmptyList() throws Exception {
		assertDoesNotThrow(() -> calculator.removeFirstResult());
		assertFalse(calculator.hasResult());
	}

	@Test
	@DisplayName("결과 리스트 불변")
	void testResultListImmutable() throws Exception {
		calculator.calculate(10.0, 5.0, "+");

		List<Double> result = calculator.getResultList();
		result.clear();

		assertTrue(calculator.hasResult());
		assertEquals(1, calculator.getResultList().size());
	}
}
