package app.numericalMethods;

import java.util.Stack;

public class Function {
	private static String forbiddenCharacters=".*[0-9\s*+-/~!|=&%$#]+.*";
	private String variableName, expressionString;
	private Stack<String> tokenizedExpression;
	
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
		return expressionString.split("\\b");
	}
	
	
	@Deprecated
	public void testStacked() {
		String testExpressionString="x x ^";
		String[] args=testExpressionString.split(" ");
		Stack<String> testStack=new Stack<String>();
		for (int i = 0; i < args.length; i++) {
			testStack.push(args[i]);
		}
		String testVariableString="x";
		setVariableName(testVariableString);
		tokenizedExpression=testStack;
		
	}
	
	public double evaluate(double value){
		PolishNotationStack PNS=new PolishNotationStack(variableName);
		return PNS.evaluate((Stack<String>) tokenizedExpression.clone(), value);
				
	}
		
	
}
