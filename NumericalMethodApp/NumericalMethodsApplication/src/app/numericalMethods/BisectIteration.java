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
	@Override
	public void setError(double error) {
		if(iterationNumber<=1)
			error=-1;
		else {
			super.setError(error);
		}
	}


	public double getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(double upperLimit) {
		this.upperLimit = upperLimit;
	}

	public double getLowerEvaluated() {
		return lowerEvaluated;
	}

	public void setLowerEvaluated(double lowerEvaluated) {
		this.lowerEvaluated = lowerEvaluated;
	}

	public double getUpperEvaluated() {
		return upperEvaluated;
	}

	public void setUpperEvaluated(double upperEvaluated) {
		this.upperEvaluated = upperEvaluated;
	}
	
}
