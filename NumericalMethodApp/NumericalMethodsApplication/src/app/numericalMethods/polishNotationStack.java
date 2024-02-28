package app.numericalMethods;

import java.util.Stack;

public class polishNotationStack {
	private String variableName;
	private double varValue;
	public polishNotationStack(String varName) {
		variableName=varName;
	}
	
	
	public double evaluate(Stack<String> expression,String varName,double value) {
		variableName=varName;
		return evaluate(expression,value);
	}
	public double evaluate(Stack<String> expression,double value) {
		varValue=value;
		return evaluate(expression);
	}
	public double evaluate(Stack<String> expressionStack) {
		String token=expressionStack.pop();
		double result=0.0;
		switch(token) {
		case "+":result=evaluate(expressionStack)+evaluate(expressionStack);
		break;
		case "*":result=evaluate(expressionStack)*evaluate(expressionStack);
		break;
		case "/":result=evaluate(expressionStack)/evaluate(expressionStack);
		break;
		case "-":result=evaluate(expressionStack)-evaluate(expressionStack);
		break;
		case "%":result=evaluate(expressionStack)%evaluate(expressionStack);
		break;
		case "^":result=Math.pow(evaluate(expressionStack),evaluate(expressionStack));
		break;
		case "sin":result=Math.sin(evaluate(expressionStack));
		break;
		case "cos":result=Math.cos(evaluate(expressionStack));
		break;
		case "ln":result=Math.log(evaluate(expressionStack));
		break;
		case "sqrt":
		case "root":result=Math.sqrt(evaluate(expressionStack));
		break;
		case "abs":result=Math.abs(evaluate(expressionStack));
		break;
		case "tan":result=Math.tan(evaluate(expressionStack));
		break;
		case "negative":result=-evaluate(expressionStack);
		break;
		case "e":result=Math.E;
		break;
		case "pi":result=Math.PI;
		break;
		default:
			if (token.equals(variableName)) {
				result=varValue;
			}else {
				result=Double.parseDouble(token);
			}
		}
		
		
		return result;
	}
}
