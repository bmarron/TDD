package fr.dawan.formation.TDD;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParamterizedDivideTests {
	private double nombreADiviser, diviseur, resultat, precision;
	private Calculator calc;
	
	@Before
	public void init() {
		calc = new Calculator();
	}
	
	@Parameters
	public static Collection<Double[]> initParameters() {
		Collection<Double[]> result =  Arrays.asList(new Double[][] {
			{6.0, 2.0, 3.0, 0.0},
			{2.0, 2.0, 1.0, 0.0},
			{2.0, 0.0, Double.POSITIVE_INFINITY, 0.0},
			{-2.0, 0.0, Double.NEGATIVE_INFINITY, 0.0},
			{0.0, 2.0, 0.0, 0.0},
			{2.0, 6.0, 0.333333333, 0.000001}
		});
		return result;
	}

	public ParamterizedDivideTests(Double nombreADiviser, Double diviseur
			, Double resultat, Double precision ) {
		this.nombreADiviser = nombreADiviser;
		this.diviseur = diviseur;
		this.resultat = resultat;
		this.precision = precision;
	}
	
	@Test
	public void testDivision() {
		assertEquals(resultat, calc.divide(nombreADiviser, diviseur), precision);
	}

}
