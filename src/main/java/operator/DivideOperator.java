package operator;

public class DivideOperator implements Operator {
	@Override
	public double operate(double a, double b) {
		return (double)a / b;
	}
}
