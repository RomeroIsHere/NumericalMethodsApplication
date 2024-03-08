package app.numericalMethods.matrixSolver;

public class Matrix {
	private double[][] matrixArray;
	private int rows, columns;
	public Matrix(int rows, int columns) {
		if (rows>0) {
			this.rows=rows;
			if (columns>0) {
				this.columns=columns;
				matrixArray=new double[rows][columns];
			}
		}
	}
	public Matrix(double[][] arr) {
		this.matrixArray=arr.clone();
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
	public void sumRows(int sumatorRow, int sumandRow) {
		if (sumatorRow>=0&&sumatorRow<=rows&&sumandRow>=0&&sumandRow<=rows) {
			for (int column = 0; column < columns; column++) {
				matrixArray[sumandRow][column]+=matrixArray[sumatorRow][column];
			}
		}
	}
	public void substractRows(int sumatorRow, int sumandRow) {
		if (sumatorRow>=0&&sumatorRow<=rows&&sumandRow>=0&&sumandRow<=rows) {
			for (int column = 0; column < columns; column++) {
				matrixArray[sumandRow][column]-=matrixArray[sumatorRow][column];
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
	public void substractColumns(int sumatorColumn, int sumandColumn) {
		if (sumatorColumn>=0&&sumatorColumn<=rows&&sumandColumn>=0&&sumandColumn<=rows) {
			for (int row = 0; row < rows; row++) {
				matrixArray[row][sumandColumn]-=matrixArray[row][sumatorColumn];
			}
		}
	}
}
