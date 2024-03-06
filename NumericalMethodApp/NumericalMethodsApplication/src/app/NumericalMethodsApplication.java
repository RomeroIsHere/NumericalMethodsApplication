package app;

import app.numericalMethods.*;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		
		
		String testExpression="x^4-2*x^3-12*x^2+16*x-40",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		Bisect bisect=new Bisect(fun, 4.2, 4.4, 0.01);
		Iteration bye;
		do {
			bye=bisect.nextStep();
			double hey=bye.getAproximation();
			System.out.println("__________________");
			System.out.println(bye.getIterationNumber());
			System.out.println(hey);
			System.out.println(fun.evaluate(hey));
			System.out.println(bye.getError());
		}while(bye.getError()>0.01);
		
		Secant sec=new Secant(fun,5, 6, 0.01);
		do {
			bye=sec.nextStep();
			double hey=bye.getAproximation();
			System.out.println("__________________");
			System.out.println(bye.getIterationNumber());
			System.out.println(hey);
			System.out.println(fun.evaluate(hey));
			System.out.println(bye.getError());
		}while(bye.getError()>0.01);
		
		
	}
}
