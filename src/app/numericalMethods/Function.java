package app.numericalMethods;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Function {
	protected static String forbiddenCharacters=".*[0-9\s\\*+-/~!|=&%$#\\^]+.*";
	protected String variableName, expressionString;
	protected Stack<String> polishExpressionStack;
	
	public Function(String variableName, String expression){
	setExpressionString(expression);
	setVariableName(variableName);
	
	}
	public Stack<String> getPolishExpressionStack() {
		return polishExpressionStack;
	}
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		if (variableName.matches(forbiddenCharacters)) {
			throw new IllegalArgumentException("Forbidden Characters Found in Variable Name:"+variableName);
		}else {
			this.variableName=variableName;
		}
	}
	public String getExpressionString() {
		return expressionString;
	}
	public void setExpressionString(String expressionString) {
		this.expressionString = expressionString;
		polishExpressionStack=PolishNotationStack.buildStack(getTokenizedExpression());
	}
	public String[] getTokenizedExpression() {
		MathTokenizer mTokenizer=new MathTokenizer(expressionString);
		return mTokenizer.tokenizedExpression();
	}
	
	@SuppressWarnings("unchecked")
	public double evaluate(double value){
		PolishNotationStack PNS=new PolishNotationStack(variableName);
		return PNS.evaluate((Stack<String>) polishExpressionStack.clone(), value);	
	}	
	public double evaluate(double value,int rounding) {
		BigDecimal bDecimal=new BigDecimal(Double.toString(evaluate(value)));
		bDecimal=bDecimal.setScale(rounding,RoundingMode.HALF_UP);
		return bDecimal.doubleValue();
	}
	
	public double[] evaluate(double lower, double upper, int sections){
		double[] values=new double[sections];
		double increment=(upper-lower)/sections;
		double value=lower;
		for (int i = 0; i < values.length; i++,value+=increment) {
			values[i]=evaluate(value);
		}
		return values;
	}
}
