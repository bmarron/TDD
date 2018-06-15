package fr.dawan.formation.TDD;

import java.math.BigDecimal;
import java.util.Arrays;

public class Calculator {
	
	private double lastResult;
	private String name;

	public int somme(int i, int j) {
		lastResult = somme((double)i, (double)j);
		return (int)lastResult;
	}

	public double somme(double d, double e) {
		lastResult = d+e;
		return lastResult;
	}

	public int somme(int... entiers) {
		lastResult = Arrays.stream(entiers).sum();
		return (int)lastResult;
	}

	public double somme(double... doubles) {
//		double resultat = Arrays.stream(doubles).sum();
		double resultat = 0;
		for (double d : doubles) {
			resultat += d;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lastResult = resultat;
		return resultat;
	}

	public int somme(String string1, String string2) {
		int a = Integer.parseInt(string1);
		int b = Integer.parseInt(string2);
		lastResult = a+b;
		return (int)lastResult;
	}
	

	public double divide(double doubleToDivide, double dividor) {
		if (dividor == 0) {
			lastResult = 0;
		} else {
			BigDecimal num = BigDecimal.valueOf(doubleToDivide);
			BigDecimal denom = BigDecimal.valueOf(dividor);
			BigDecimal result = num.divide(denom);
			lastResult = result.doubleValue();
		}
		return lastResult;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLastResult() {
		return lastResult;
	}

	public void setLastResult(double lastResult) {
		this.lastResult = lastResult;
	}
}
