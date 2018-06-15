package fr.dawan.formation.TDD.fitnesse;

import fit.ColumnFixture;
import fr.dawan.formation.TDD.Calculator;

public class Division extends ColumnFixture{
	private double numerator, denominator;
	private Calculator calc = new Calculator();

	public void setNumerator(double numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(double denominator) {
		this.denominator = denominator;
	}
	
	public double resultat() {
		return calc.divide(numerator, denominator);
	}
}
