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
		
		
		
		// TODO Auto-generated constructor stub
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
			//TODO: Add Column switcher	
		}
		
	}
	
}
