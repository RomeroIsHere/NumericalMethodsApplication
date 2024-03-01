package app;

import java.util.Arrays;

import app.numericalMethods.*;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		
		
		String testExpression="x^2-4*x+2",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		
		System.out.println(fun.getPolishExpressionStack().toString());
		
		System.out.println(fun.evaluate(3,6));
	}
}
