package app.interpolationMethods;

import java.util.Arrays;

import app.functions.Function;

public class DividedDifferences {
	
	double[] inputValues;
	double[] outputValues;
	
	public DividedDifferences(double[] input,double[] output) {
	this.inputValues=input;
	this.outputValues=output;
	}
	public DividedDifferences() {
		
	}
	
	public Function interpolate() {
		return interpolate(inputValues,outputValues);
	}
	
	public Function interpolate(double[] input,double[] output) {
		//Assume in order from 0 to 1 to 2 to ... to n
		StringBuilder functionBuilder=new StringBuilder();
		
		if (input.length!=output.length) {
			throw new IllegalArgumentException("Ingreso y salida de Tamaño Distinto");
		}else {
			for (int i = 1; i <= output.length; i++) {
				functionBuilder.append(buildString(Arrays.copyOfRange(input, 0, i), Arrays.copyOfRange(output, 0, i)));
				if (i!=output.length) {
					functionBuilder.append("+");
				}
			}
		}
		
		return new Function("x", functionBuilder.toString());
	}
	
	private String buildString(double[] input,double[] output) {
		StringBuilder built=new StringBuilder();
		built.append(factor(reverse(input),reverse(output)));
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(output));
		if (input.length!=1) {
			for (int i = 1; i < output.length; i++) {
				built.append("*");
				built.append("(x-"+input[i]+")");
			}
		}
		return built.toString();
	}
	
	private double[] reverse(double[] ds) {
		
		for(int i = 0; i < ds.length / 2; i++)
		{
		    double temp = ds[i];
		    ds[i] = ds[ds.length - i - 1];
		    ds[ds.length - i - 1] = temp;
		}
		return ds;
	}
	public double factor(double[] input,double[] output) {
		if (input.length!=output.length) {
			throw new IllegalArgumentException("Ingreso y salida de Tamaño Distinto");
		}else if (input.length==1) {
			return factor(input[0], output[0]);
		}else if (input.length==2) {
			return  (output[0]-output[1])/(input[0]-input[1]);
		}else {
			double leftSide=factor(Arrays.copyOfRange(input, 0, input.length-1),Arrays.copyOfRange(output, 0, output.length-1));
			double rightSide=factor(Arrays.copyOfRange(input, 1, input.length),Arrays.copyOfRange(output, 1, output.length));
			return (leftSide-rightSide)/(input[0]-input[input.length-1]);
		}
		
	}
	public double factor(double input,double output) {
		return output;
	}
	
	
	

}
