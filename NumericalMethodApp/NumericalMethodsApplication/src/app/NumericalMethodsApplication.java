package app;

import app.numericalMethods.*;

//import numericalMethods.Bisect;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		System.out.println("Felt");
		Bisect bis = new Bisect();
		bis.toString();
		String testExpression="x^3";
		Function fun=new Function("!+invalid String-Example*/-+","testString");
	}
}
