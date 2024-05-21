package app;



import java.util.Arrays;

import app.functions.Function;
import app.functions.MultivariableFunction;
import app.interpolationMethods.DividedDifferences;
import app.numericalMethods.*;
import app.numericalMethods.matrixSolver.*;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		/*DividedDifferences dividedDifferences=new DividedDifferences();
		
		double[] output= {30,48,67,91,135};
		Function fun=dividedDifferences.interpolate(input,output);
		String testExpression="x^4-2*x^3-12*x^2+16*x-40",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		*/
		Function fun=new Function("x","1/x");
		double result=0;
		for (int i = 0; i <= 9; i++) {
			double valor=i*5/3.0-4;
			System.out.println(valor);
			System.out.println(fun.evaluate(valor));
			if (i%3==0 && i!=9 &&i!=0) {
				result+=2*fun.evaluate(valor);
			}else if (i!=0&&i!=6) {
				result+=3*fun.evaluate(valor);				
			}else
				result+=fun.evaluate(valor);
		}
		System.out.println(5*result/8);
		
		double[][] input = {{1,1,1},{1,2,3}};
		GaussSeidel gaussSeidel=new GaussSeidel(new Matrix(input));
		double[] initial= {1,1};
		gaussSeidel.initializeValues(initial);
		
		for (int i = 0; i < 10; i++) {
			SeidelIteration sIteration=gaussSeidel.step();
			System.out.println(sIteration);
			System.out.println(sIteration.getError().length);
		}
		
		
	}
}
