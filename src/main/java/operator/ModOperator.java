package operator;

public class ModOperator implements Operator {
	@Override
	public double operate(double a, double b) {
		return a % b;
	}
}
