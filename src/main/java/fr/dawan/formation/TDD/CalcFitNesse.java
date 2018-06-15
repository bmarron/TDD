package fr.dawan.formation.TDD;

import fit.ColumnFixture;

public class CalcFitNesse extends ColumnFixture{
	private double numerator, denominator;

	public void setNumerator(double numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(double denominator) {
		this.denominator = denominator;
	}

	public double result() {
		return numerator/denominator;
	}
}
