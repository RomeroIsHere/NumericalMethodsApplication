package app.numericalMethods.matrixSolver;

public class Matrix {
	private double[][] matrixArray;
	private int rows, columns, iteration;
	public Matrix(int rows, int columns) {
		if (rows>0) {
			this.rows=rows;
			if (columns>0) {
				this.columns=columns;
				matrixArray=new double[rows][columns];
			}
		}
	}
	public void setIteration(int i) {
		iteration=i>0?i:0;
	}
	public int getIterationNumber() {
		return iteration;
	}
	public Matrix(double[][] arr) {
		this.matrixArray=deepCopy(arr);
	}
	public double[][] getMatrixArray() {
		return matrixArray;
	}
	public void setMatrixArray(double[][] matrixArray) {
		this.matrixArray = matrixArray;
	}
	public void switchRows(int firstRow, int secondRow) {
		
		if (firstRow>=0&&firstRow<=rows&&secondRow>=0&&secondRow<=rows) {
			double[] temp=matrixArray[firstRow];
			matrixArray[firstRow]=matrixArray[secondRow];
			matrixArray[secondRow]=temp;
		}
	}
	public void switchColumns(int firstColumn, int secondColumn) {
		if (firstColumn>=0&&firstColumn<=columns&&secondColumn>=0&&secondColumn<=columns) {
			for (int row = 0; row < rows; row++) {
				double temp=matrixArray[row][firstColumn];
				matrixArray[row][firstColumn]=matrixArray[row][secondColumn];
				matrixArray[row][secondColumn]=temp;
			}
		}
		
	}
	public void sumRows(int sumatorRow, int sumandRow,double factor) {
		if (sumatorRow>=0&&sumatorRow<=rows&&sumandRow>=0&&sumandRow<=rows) {
			for (int column = 0; column < columns; column++) {
				matrixArray[sumandRow][column]+=matrixArray[sumatorRow][column]*factor;
			}
		}
	}
	public void sumColumns(int sumatorColumn, int sumandColumn) {
		if (sumatorColumn>=0&&sumatorColumn<=rows&&sumandColumn>=0&&sumandColumn<=rows) {
			for (int row = 0; row < rows; row++) {
				matrixArray[row][sumandColumn]+=matrixArray[row][sumatorColumn];
			}
		}
	}
	public void multiplyRow(int row,double factor) {
		if (row>=0&&row<rows) {
			for (int column = 0; column < columns; column++) {
				matrixArray[row][column]*=factor;
			}
		}
	}
	public Matrix clone() {
		return new Matrix(matrixArray);
	}
	
	private double[][] deepCopy(double[][] original){
		double[][] copy=new double[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[i].length; j++) {
				copy[i][j]=original[i][j];
			}
		}
		return copy;
	}
}
