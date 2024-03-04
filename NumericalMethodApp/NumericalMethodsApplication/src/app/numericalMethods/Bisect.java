package app.numericalMethods;

import java.util.ArrayList;

public class Bisect{
private Function function;
private double lowerLimit, upperLimit,currentResult, allowedError;
private int iteration;
public Bisect(Function function, double lowerLimit, double upperLimit, double allowedError) {
	this.function = function;
	this.lowerLimit = lowerLimit;
	this.upperLimit = upperLimit;
	this.allowedError = allowedError;
	iteration=1;
}

public Iteration nextStep() {
	BisectIteration bis;
	double nextApprox=(lowerLimit+upperLimit)/2.0;
	double lowEval=function.evaluate(lowerLimit);
	double uppEval=function.evaluate(upperLimit);
	double calculatedError=Math.abs(((currentResult-nextApprox)/nextApprox)*100);
	bis=new BisectIteration(iteration++, nextApprox, calculatedError, lowerLimit, upperLimit, lowEval, uppEval);
	if (lowEval*function.evaluate(nextApprox)>=0)
		lowerLimit=nextApprox;
	if (lowEval*function.evaluate(nextApprox)<=0)
		upperLimit=nextApprox;
	currentResult=nextApprox;
		
	
	return bis;
}


public ArrayList<BisectIteration> solve() {
	ArrayList<BisectIteration> listOfIterations=new ArrayList<BisectIteration>();
	BisectIteration current=null;
	do {
		current=(BisectIteration)nextStep();
		listOfIterations.add(current);
	} while (current.getError()>allowedError);
	return listOfIterations;
}

}
