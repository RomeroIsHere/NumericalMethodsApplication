package app.functions;

import java.util.Stack;

public class MultivariableFunction extends Function {
	private String[] varNames;
	public MultivariableFunction(String expression,String... variableNames) {
		super(variableNames[0],expression);
		varNames=variableNames;
	}
	@SuppressWarnings("unchecked")
	public double evaluate(double... ds){
		PolishNotationStack PNS=new PolishNotationStack(varNames);
		return PNS.evaluate((Stack<String>) polishExpressionStack.clone(),ds);
	}

}
