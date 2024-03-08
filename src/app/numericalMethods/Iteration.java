package app.numericalMethods;

public abstract class Iteration {

protected double aproximation,error;
protected int iterationNumber;
public Iteration(int iterationNumber,double aproximation, double error) {
	this.aproximation = aproximation;
	this.error = error;
	this.iterationNumber = iterationNumber;
}
public double getAproximation() {
	return aproximation;
}
public void setAproximation(double aproximation) {
	this.aproximation = aproximation;
}
public double getError() {
	return error;
}
public void setError(double error) {
	if(iterationNumber<=1)
		this.error=-1;
	else {
		this.error=Math.abs(error);
	}
}
public int getIterationNumber() {
	return iterationNumber;
}
public void setIterationNumber(int iterationNumber) {
	this.iterationNumber = iterationNumber;
}

}
