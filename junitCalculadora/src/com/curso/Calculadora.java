package com.curso;

public class Calculadora {
	
	//@Inyect
	public CloudCalculadora cloudCalc;
	
	public double suma(double a, double b) {
		return a+b; 
	}
	
	public double sumaCloud(double a, double b) {
		double res = cloudCalc.sumar(a, b);
		return res;
	}

}
