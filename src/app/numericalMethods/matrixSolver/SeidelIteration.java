package app.numericalMethods.matrixSolver;

public class SeidelIteration {
	private double[] values,error;
	private int step;
	public SeidelIteration(int step,int variableCount) {
		this.step=step;
		values =new double[variableCount];
	for (int i = 0; i < variableCount; i++) {
		values[i]=0;
	}
	}
	public SeidelIteration(int step,double[] ds,double[] error) {
		this.step=step;
		values=ds;
		this.error=error;
	}
	public double[] getValues() {
		return values;
	}
	public double getValueByIndex(int i) {
		return values[i];
	}
	
	public double[] getError() {
		return error;
	}
	public double getErrorByIndex(int i) {
		return error[i];
	}
	public int getStep() {
		return step;
	}
	@Override
	public String toString() {
		String returnal=step+"\t";
		double max=0;
		for (int i = 0; i < error.length; i++) {
			returnal+=values[i]+"\t";
			returnal+=error[i]+"\t";
			max=error[i]>max?error[i]:max;
		}
		returnal+=max;
		return returnal;
	}
	
}
