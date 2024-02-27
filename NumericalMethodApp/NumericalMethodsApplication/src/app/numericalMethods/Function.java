package app.numericalMethods;

import java.util.Stack;

public class Function {
	private static String forbiddenCharacters=".*[0-9\s*+-/~!|=&%$#]+.*";
	private String variableName, expressionString;
	private Stack<String> tokenizedExpression;
	
	public Function(String variableName, String expression){
	expressionString=expression;
		
	
	}
	private Stack<String> tokenize(String expressionString){
		Stack<String> tokenStack=new Stack<String>();
		
		return tokenStack;
	}
	
	public double evaluate(double value){
		Stack<String> tokenizedStack=((Stack<String>)tokenizedExpression.clone());
		Stack<Double> tokenValues=new Stack<Double>();
		double temporaryResult=0.0;
		
		while (!tokenizedStack.empty()) {
			String bufferString=tokenizedStack.pop();
			if (tokenType(bufferString)==2) {
				temporaryResult=operate(bufferString, tokenValues.pop(),tokenValues.pop());
				tokenValues.push(temporaryResult);
			}else if (tokenType(bufferString)==1) {
				temporaryResult=operate(bufferString, tokenValues.pop());
				tokenValues.push(temporaryResult);
			}else if (tokenType(bufferString)==0) {
				if (bufferString.equals(variableName)) {
				tokenValues.push(value);	
				}
				
			} else {
				throw new NoSuchMethodError("Something has gone Terribly wrong with unexpected token: "+bufferString);
			}
		}
		return 0.0;
	}
	private double operate(String binaryOperator, double first, double second) {
		double result=0.0;
		switch(binaryOperator) {
		case "+":result=first+second;
		break;
		case "*":result=first*second;
		break;
		case "/":result=first/second;
		break;
		case "-":result=first-second;
		break;
		case "%":result=first%second;
		break;
		}
		return result;
	}
	private double operate(String operator,double argument ) {
		double result=0.0;
		switch (operator) {
		case "sin":result=Math.sin(argument);
		break;
		case "cos":result=Math.cos(argument);
		break;
		case "ln":result=Math.log(argument);
		break;
		case "sqrt":
		case "root":result=Math.sqrt(argument);
		break;
		case "abs":result=Math.abs(argument);
		break;
		case "tan":result=Math.tan(argument);
		break;
		case "negative":result=-argument;
		}
		return result;
	}
	private int tokenType(String operand) {
	int type=0;
	switch (operand) {
	case "+":
	case "*":
	case "/":
	case "-":
	case "%":
		type=2;//binary operator
		break;
	case "sin":
	case "cos":
	case "ln":
	case "root":
	case "abs":
	case "sqrt":
	case "tan":
	case "negative"://special unary operator Negative at start of expression or Parenthesis
			type=1;//unary operator
	}
	return type;
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
		tokenizedExpression=tokenize(expressionString);
	}
	public Stack<String> getTokenizedExpression() {
		return tokenizedExpression;
	}
	
	
}
