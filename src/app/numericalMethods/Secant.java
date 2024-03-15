package app.numericalMethods;

import java.util.ArrayList;

import app.functions.Function;

public class Secant{
	private Function function;
	private double previous,current,allowedError;
	private int iteration;
	public Secant(Function fun,double previous, double current, double allowedError) {
		this.function=fun;
		this.previous = previous;
		this.current = current;
		this.allowedError = allowedError;
		iteration=1;
	}

	public SecantIteration nextStep() {
		
		double next=current-((function.evaluate(current)*(previous-current))/(function.evaluate(previous)-function.evaluate(current)));
		double calculatedError=Math.abs(((current-next)/next)*100);
		SecantIteration sit=new SecantIteration(iteration++, next,calculatedError, previous, current, function.evaluate(previous), function.evaluate(current));
		previous=current;
		current=next;
		return sit;
	}

	public ArrayList<SecantIteration> solve() {
		ArrayList<SecantIteration> listOfIterations=new ArrayList<SecantIteration>();
		SecantIteration current=null;
		do {
			current=nextStep();
			listOfIterations.add(current);
		} while (current.getError()>allowedError);
		return listOfIterations;
	}

}
