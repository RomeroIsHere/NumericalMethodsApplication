package app.numericalMethods;

public class BisectIteration extends Iteration{
	
	

	private double lowerLimit, upperLimit, lowerEvaluated,upperEvaluated;
	
	
	
	public BisectIteration(int iterationNumber,double aproximation, double error, double lowerLimit, double upperLimit,
			double lowerEvaluated, double upperEvaluated) {
		super(iterationNumber,aproximation, error);
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.lowerEvaluated = lowerEvaluated;
		this.upperEvaluated = upperEvaluated;
	}
	
	public double getLowerLimit() {
		return lowerLimit;
	}
	public double getUpperLimit() {
		return upperLimit;
	}
	public double getLowerEvaluated() {
		return lowerEvaluated;
	}
	public double getUpperEvaluated() {
		return upperEvaluated;
	}
}
