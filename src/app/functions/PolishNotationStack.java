package app.functions;

import java.util.HashMap;
import java.util.Stack;

public class PolishNotationStack {
	private HashMap<String, Double> keyValuesHashMap;
	public PolishNotationStack(String varName) {
		keyValuesHashMap=new HashMap<String, Double>();
		keyValuesHashMap.put(varName, 0.0);
	}
	public PolishNotationStack(String... varNames) {
		keyValuesHashMap=new HashMap<String, Double>();
		for (String string : varNames) {
			keyValuesHashMap.put(string, 0.0);
		}
		
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
			while (!(operatorStack.isEmpty()||operatorStack.peek().matches(".*[(].*"))) {
				expressionStack.push(operatorStack.pop());
			}
			operatorStack.push(tokens[i]);
			break;
		case"*":
		case"/":
		case"%":
			while (!(operatorStack.isEmpty()||operatorStack.peek().matches(".*[(+-].*"))) {
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
		keyValuesHashMap.put(varName, value);
		return evaluate(expression,value);
	}
	public double evaluate(Stack<String> expression,double value) {
		keyValuesHashMap.replace((String)keyValuesHashMap.keySet().toArray()[0], value);
		return evaluate(expression);
	}
	public double evaluate(Stack<String> expression,String[] varNames,double[] values) {
		
		for (int i = 0; i < values.length&&i<varNames.length; i++) {
			keyValuesHashMap.put(varNames[i], values[i]);
		}
		return evaluate(expression);
	}
	public double evaluate(Stack<String> expression,double... values) {
		int i=0;
		for (String d :keyValuesHashMap.keySet())
			if (i<values.length) 
				keyValuesHashMap.replace(d, values[i++]);
			
		
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
		case "ln":result=Math.log(evaluate(expressionStack));
		break;
		case "log10":result=Math.log10(evaluate(expressionStack));
		break;
		case "sqrt":
		case "root":result=Math.sqrt(evaluate(expressionStack));
		break;
		case "abs":result=Math.abs(evaluate(expressionStack));
		break;
		case "tan":result=Math.tan(evaluate(expressionStack));
		break;
		case "arctan":result=Math.atan(evaluate(expressionStack));
		break;
		case "sin":result=Math.sin(evaluate(expressionStack));
		break;
		case "arcsin":result=Math.asin(evaluate(expressionStack));
		break;
		case "cos":result=Math.cos(evaluate(expressionStack));
		break;
		case "arccos":
		case "arcos":result=Math.acos(evaluate(expressionStack));
		break;
		case "cot":Math.tan(1.0/evaluate(expressionStack));
		break;
		case "arccot":
		case "arcot":
		break;
		case "negative":result=-evaluate(expressionStack);
		break;
		case "e":result=Math.E;
		break;
		case "pi":result=Math.PI;
		break;
		default:
			if (keyValuesHashMap.containsKey(token)) {
				result=keyValuesHashMap.get(token);	
			}else {
				try {
					result=Double.parseDouble(token);
				} catch (Exception except) {
					result=0;
					System.err.println("Unknown token or variable" + token);
				}
			}
			

		}
		return result;
	}
}
