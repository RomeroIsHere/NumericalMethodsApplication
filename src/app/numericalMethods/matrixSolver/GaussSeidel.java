package app.numericalMethods.matrixSolver;

import java.util.ArrayList;
import java.util.HashMap;

import app.functions.MultivariableFunction;

public class GaussSeidel {
	private Matrix extendedMatrix;
	private int step;
	private ArrayList<MultivariableFunction> calculatorArrayList;
	private String[] variableNameStrings;
	private HashMap<String, Double> valoresHashMap;
	
	public GaussSeidel(Matrix eqSystem) {
		extendedMatrix=eqSystem;
		step=0;
		calculatorArrayList=new ArrayList<MultivariableFunction>();
		variableNameStrings=new String[eqSystem.getColumns()-1];
		valoresHashMap=new HashMap<>();
		createFunctions();
	}
	
	private void createFunctions() {
		createVariableNames();
		calculatorArrayList.clear();
		
		for (int i = 0; i < Math.min(extendedMatrix.getColumns(),extendedMatrix.getRows()); i++) {
		calculatorArrayList.add(new MultivariableFunction(getFunctionStringByIndex(i),getByExcluding(i)));
		}
		
	}
	private String getFunctionStringByIndex(int i) {
		/*
		 * a=(r-kb-kc....-kz)/k
		 * b=(r-ka-kc....-kz)/k
		 * */
		double[][] matrix =extendedMatrix.getMatrixArray();
		String auxString="(";
		double divisor=matrix[i][i];
		auxString+=matrix[i][matrix[i].length-1];
		for (int j = 0; j < variableNameStrings.length; j++) {
			if (j!=i) {
				auxString+="-"+matrix[i][j]+"*"+variableNameStrings[j];
			}
		}
		auxString+=")/"+divisor;
		
		return auxString;
	}
	private String[] getByExcluding(int i) {
		String[] returnalStrings=new String[variableNameStrings.length-1];
		for (int j = 0; j < variableNameStrings.length; j++) {
			String string = variableNameStrings[j];
			if (i>j) {
				returnalStrings[j]=string;
			}else if(i<j) {
				returnalStrings[j-1]=string;
			}
			
		}
		return returnalStrings;
	}
	private void createVariableNames() {
		for (int i = 0; i < variableNameStrings.length; i++) {
			variableNameStrings[i]="x"+(char)('a'+i);
			System.out.println("Nombre de Variable:"+variableNameStrings[i]);
		}
	}
	public void initializeValues(double...ds) {
		int i=0;
		for (String s:variableNameStrings) {
			valoresHashMap.put(s, ds[i++]);
		}
	}
	private double[] getValuesByExcluding(int i) {
		double[] returnal=new double[variableNameStrings.length-1];
		for (int j = 0; j < variableNameStrings.length; j++) {
			if (i>j) {
				returnal[j]=valoresHashMap.get(variableNameStrings[j]);
			}else if (i<j) {
				returnal[j-1]=valoresHashMap.get(variableNameStrings[j]);
			}
		}
		return returnal;
	}
	public SeidelIteration step() {
		double[] currentValues=new double[variableNameStrings.length];
		double[] error=new double[variableNameStrings.length];
		
		for (int i = 0; i < variableNameStrings.length; i++) {
			currentValues[i]=calculatorArrayList.get(i).evaluate(getValuesByExcluding(i));
			System.out.println(calculatorArrayList.get(i).getExpressionString());
			System.out.println(i+"-Variable:"+variableNameStrings[i]);
			System.out.println(i+"-Valor:"+currentValues[i]);
			error[i]=Math.abs(((currentValues[i]-valoresHashMap.get(variableNameStrings[i]))/currentValues[i])*100);
			valoresHashMap.put(variableNameStrings[i], currentValues[i]);
		}
		step++;
		return new SeidelIteration(step, currentValues,error);
	}
	public int stepIndex() {
		return step;
	}
	
}
