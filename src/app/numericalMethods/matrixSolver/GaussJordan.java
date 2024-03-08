package app.numericalMethods.matrixSolver;

public class GaussJordan {
	private Matrix extendedMatrix;
	private int step;
	public GaussJordan(Matrix eqSystem) {
		extendedMatrix=eqSystem;
		step=0;
	}
	public Matrix step() {
		double[][] auxiliary=extendedMatrix.getMatrixArray();
		double factor=1.0/auxiliary[step][step];
		extendedMatrix.multiplyRow(step, factor);
		for (int i = 0; i < auxiliary.length; i++) {
			if (step!=i) {
				extendedMatrix.sumRows(step, i, 1.0/auxiliary[i][step]);
			}
		}
		step++;
		Matrix copyMatrix=extendedMatrix.clone();
				copyMatrix.setIteration(step);
		return copyMatrix;
	}
	
}
