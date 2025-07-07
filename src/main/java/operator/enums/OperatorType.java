package operator.enums;

public enum OperatorType {
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	MODULO("%");

	private final String symbol;

	OperatorType(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static OperatorType fromSymbol(String symbol){
		for (OperatorType opr : OperatorType.values()) {
			if (opr.getSymbol().equals(symbol)) {
				return opr;
			}
		}
		return null;
	}
}
