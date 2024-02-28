package app;

import java.util.Arrays;

import app.numericalMethods.*;

//import numericalMethods.Bisect;

public class NumericalMethodsApplication {
	public static void main(String[] args) {
		
		
		String testExpression="x^3",testVariable="x";
		Function fun=new Function(testVariable,testExpression);
		String splitterString="";
		String[] bashString= "x^3+x-16".split(splitterString);
		System.out.println(Arrays.toString(bashString));
		MathTokenizer mTokenizer=new MathTokenizer("x^3+x-16");
		while (mTokenizer.hasNext()) {
			System.out.println(mTokenizer.next());
		}
	}
}
