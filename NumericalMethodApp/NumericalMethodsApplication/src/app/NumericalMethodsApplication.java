package app;

import app.numericalMethods.*;

//import numericalMethods.Bisect;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		System.out.println("Felt");
		Bisect bis = new Bisect();
		bis.toString();
		String testExpression="x^3";
		Function fun=new Function("x","testString");
		fun.testStacked();
		
		System.out.println(fun.evaluate(0));
		System.out.println(fun.evaluate(1));
		System.out.println(fun.evaluate(2));
		System.out.println(fun.evaluate(3));
		
	}
}
