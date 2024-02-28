package app;

import app.numericalMethods.*;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		
		
		String testExpression="cos(2*xanax)*e^cos(2*xanax)",testVariable="xanax";
		Function fun=new Function(testVariable,testExpression);
		System.out.println(fun.evaluate(2,6));
	}
}
