package app;



import java.util.Arrays;

import app.functions.Function;
import app.functions.MultivariableFunction;
import app.interpolationMethods.DividedDifferences;
import app.numericalMethods.*;
import app.numericalMethods.matrixSolver.*;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		DividedDifferences dividedDifferences=new DividedDifferences();
		double[] input = {0,1,2,3,4};
		double[] output= {30,48,67,91,135};
		Function fun=dividedDifferences.interpolate(input,output);
		/*String testExpression="x^4-2*x^3-12*x^2+16*x-40",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		*/
		System.out.println(fun.getExpressionString());
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			System.out.println(fun.evaluate(i));
		}
		
		
	}
}
