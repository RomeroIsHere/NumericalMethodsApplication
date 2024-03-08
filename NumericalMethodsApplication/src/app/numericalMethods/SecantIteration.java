package app.numericalMethods;

public class SecantIteration extends Iteration {
private double previous,current, prevEval,currEval;

public SecantIteration(int iterationNumber, double aproximation, double error, double previous, double current,
		double prevEval, double currEval) {
	super(iterationNumber, aproximation, error);
	this.previous = previous;
	this.current = current;
	this.prevEval = prevEval;
	this.currEval = currEval;
}

public double getPrevious() {
	return previous;
}

public double getCurrent() {
	return current;
}

public double getPrevEval() {
	return prevEval;
}

public double getCurrEval() {
	return currEval;
}


}
