package app.numericalMethods.matrixSolver;

import java.util.ArrayList;

import app.functions.MultivariableFunction;

public class GaussSeidel {
	private Matrix extendedMatrix;
	private int step;
	private ArrayList<MultivariableFunction> calculatorArrayList;
	public GaussSeidel(Matrix eqSystem) {
		extendedMatrix=eqSystem;
		step=0;
	}
	public void createFunctions() {
		
	}

}
