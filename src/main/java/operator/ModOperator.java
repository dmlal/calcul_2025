package operator;

public class ModOperator implements Operator {
	@Override
	public double operate(int a, int b) {
		return a % b;
	}
}
