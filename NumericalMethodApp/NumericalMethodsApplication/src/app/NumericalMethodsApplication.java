package app;

import java.util.Arrays;

import app.numericalMethods.*;

//import numericalMethods.Bisect;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		
		
		String testExpression="x^x",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		for (int i = 0; i < 9; i++) {
			System.out.println(fun.evaluate(i));
		}
	}
}
