package fr.dawan.formation.TDD;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class JUnitparamsDivideTests {
	
	@Test
	@Parameters({
		"6, 2, 3.0, 0.0",
		"2, 2, 1.0, 0.0",
		"2.0, 0.0, 0.0, 0.0",
		"0.0, 0.0, 0.0, 0.0",
		"-0.0, 0.0, 0.0, 0.0",
		"-2.0, 0.0, 0.0, 0.0",
		"0.0, 2.0, 0.0, 0.0",
		"2.0, 6.0, 0.333333333, 0.000001"})
	public void testDivision(Double nombreADiviser, Double diviseur
			, Double resultat, Double precision) {
		Calculator calc = new Calculator();
		if (diviseur == 0) {
			if (nombreADiviser > 0) {
				assertEquals(Double.POSITIVE_INFINITY, calc.divide(nombreADiviser, diviseur), precision);
			}
			if (nombreADiviser == 0) {
				assertEquals(Double.NaN, calc.divide(nombreADiviser, diviseur), precision);
			}
			if (nombreADiviser < 0) {
				assertEquals(Double.NEGATIVE_INFINITY, calc.divide(nombreADiviser, diviseur), precision);
			}
		} else {
			assertEquals(resultat, calc.divide(nombreADiviser, diviseur), precision);
		}
	}

}
