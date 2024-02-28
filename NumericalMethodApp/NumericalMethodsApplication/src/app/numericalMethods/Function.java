package app.numericalMethods;

import java.util.Stack;

public class Function {
	private static String forbiddenCharacters=".*[0-9\s*+-/~!|=&%$#]+.*";
	private String variableName, expressionString;
	private Stack<String> polishExpressionStack;
	
	public Function(String variableName, String expression){
	expressionString=expression;
	setVariableName(variableName);
	
	}

	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		if (variableName.matches(forbiddenCharacters)) {
			throw new IllegalArgumentException("Forbidden Characters Found in Variable Name");
		}else {
			this.variableName=variableName;
		}
	}
	public String getExpressionString() {
		return expressionString;
	}
	public void setExpressionString(String expressionString) {
		this.expressionString = expressionString;
		MathTokenizer.tokenize(expressionString);
	}
	public String[] getTokenizedExpression() {
		MathTokenizer mTokenizer=new MathTokenizer(expressionString);
		return mTokenizer.tokenizedExpression();
	}
	
	public double evaluate(double value){
		PolishNotationStack PNS=new PolishNotationStack(variableName);
		return PNS.evaluate((Stack<String>) polishExpressionStack.clone(), value);
				
	}
	private void buildStackExpression() {
		//TODO: make postfix or prefix based on the tokens given by @class MathTokenizer.java
	}
		
	
}
