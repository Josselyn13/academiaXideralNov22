package com.curso.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.curso.*;

class CalculadoraTest {

	@Test
	void test() {
		Calculadora cal = new Calculadora();
		double res = 10.0;
		assertEquals(res, cal.suma(5.0,5.0));
	}
	
	@Test
	void testCloudWrong() {
		Calculadora cal = new Calculadora();
		
		//MALA PRACTICA, 
		//TOMAR RESPONSABILIDAD DE UN SERVICIO EXTERNO
		CloudCalculadora cCloud = new CloudCalculadora() {
			@Override
			public double sumar(double x, double y) {
				return x+y;
			}
		};
		
		cal.cloudCalc = cCloud;
		
		double res = 10.0;
		assertEquals(res, cal.sumaCloud(5.0,5.0));
	}

}
