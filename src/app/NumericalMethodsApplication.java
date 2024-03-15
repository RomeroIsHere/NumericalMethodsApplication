package app;

import app.numericalMethods.*;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		
		
		String testExpression="x^4-2*x^3-12*x^2+16*x-40",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		MultivariableFunction Mfun=new MultivariableFunction("x+y", "x","y");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i+", "+j+": "+Mfun.evaluate(i,j+0.0));
			}
		}
		
	}
}
