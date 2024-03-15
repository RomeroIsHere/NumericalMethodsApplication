package app.numericalMethods.matrixSolver;

import app.numericalMethods.MultivariableFunction;

public class GaussSeidel {
	private Matrix extendedMatrix;
	private int step;
	private MultivariableFunction mf;
	public GaussSeidel(Matrix eqSystem) {
		extendedMatrix=eqSystem;
		step=0;
	}

}
