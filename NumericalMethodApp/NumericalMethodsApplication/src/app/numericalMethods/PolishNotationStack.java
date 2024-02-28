package app.numericalMethods;

import java.util.Stack;

public class PolishNotationStack {
	private String variableName;
	private double varValue;
	public PolishNotationStack(String varName) {
		variableName=varName;
	}
	public static Stack<String> buildStack(String[] tokens){
	Stack<String> operatorStack=new Stack<String>();
	Stack<String> expressionStack =new Stack<String>();
	for (int i = 0; i < tokens.length; i++) {
		
		switch (tokens[i]) {
		case "(":
			operatorStack.push(tokens[i]);
			break;
		case "+":
		case "-":
			while (!(operatorStack.isEmpty()||operatorStack.peek().matches(".*[(+-].*"))) {
				expressionStack.push(operatorStack.pop());
			}
			operatorStack.push(tokens[i]);
			break;
		case"*":
		case"/":
		case"%":
			while (!(operatorStack.isEmpty()||operatorStack.peek().matches(".*[\\*(+-/%].*"))) {
				expressionStack.push(operatorStack.pop());
			}
			operatorStack.push(tokens[i]);
			break;
		case "^":
			while (!(operatorStack.isEmpty()||operatorStack.peek().matches(".*[\\*(+-/%^].*"))) {
				expressionStack.push(operatorStack.pop());
			}
			operatorStack.push(tokens[i]);
			break;
		case ")":
			while (!operatorStack.peek().contains("(")) {
				expressionStack.push(operatorStack.pop());
			}
			operatorStack.pop();
			break;

		case "sqrt":
		case "root":
		case "sin":
		case "cos":
		case "ln":
		case "abs":
		case "tan":
		case "negative":
			operatorStack.push(tokens[i]);
		break;
		default:
			expressionStack.push(tokens[i]);
		}
		
	}
	while (!operatorStack.isEmpty()) {
		expressionStack.push(operatorStack.pop());
	}
	return expressionStack;
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
		double first,second;
		double result=0.0;
		switch(token) {
		case "+":first=evaluate(expressionStack);
		second=evaluate(expressionStack);
			result=second+first;
		break;
		case "*":first=evaluate(expressionStack);
		second=evaluate(expressionStack);
			result=second*first;
		break;
		case "/":first=evaluate(expressionStack);
		second=evaluate(expressionStack);
		result=second/first;
		break;
		case "-":
			
			first=evaluate(expressionStack);
			second=evaluate(expressionStack);
			result=second-first;
		break;
		case "%":
			first=evaluate(expressionStack);
			second=evaluate(expressionStack);
			result=second%first;
		break;
		
		case "^":
			first=evaluate(expressionStack);
			second=evaluate(expressionStack);
			result=Math.pow(second,first);
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
