package fr.dawan.formation.TDD;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SommeTestCase {
	
	private static final double PRECISION = 0.00001;
	private Calculator calc;
	private static FileWriter logFile;

	public SommeTestCase() {
		calc = new Calculator();
	}

	@BeforeClass
	public static void initContext() {
		// Init context
		try {
			logFile = new FileWriter("log.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void releaseResources() {
		try {
			logFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before
	public void clearLastResult() {
		calc.setLastResult(0);
	}
	
	@After
	public void logResult() {
		try {
			logFile.write("Result = "+calc.getLastResult());
			logFile.write(System.lineSeparator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void sommeDeuxEntiers() {
		int resultat = calc.somme(2,3);
		assertEquals(5, resultat);
		//fail("vous n'auriez jamais du arriver jusqu'ici");
	}
	
	@Test
	public void sommeDeuxFlottants() {
		
		double resultat = calc.somme(2.7, 3.5);
		assertEquals(6.2, resultat, PRECISION);
	}
	
	@Test
	public void sommeFlottantEntier() {
		
		double resultat = calc.somme(2, 3.5);
		assertEquals(5.5, resultat, PRECISION);
	}
	
	@Test
	public void sommePlusieursEntiers() {
		
		int[] entiers = {1,2,3,5,8,7,9};
		int resultat = calc.somme(entiers);
		assertEquals(35, resultat);
	}
	
	@Test
	public void sommePlusieursFlottants() {
		
		double[] doubles = {1.2,2.4,3.1};
		double resultat = calc.somme(doubles);
		assertEquals(6.7, resultat, PRECISION);
	}
	
	@Test
	public void sommePlusieursNombres() {
		
		double resultat = calc.somme(1, 3.4 , 5.4, 8, 4);
		assertEquals(21.8, resultat, PRECISION);
		assertTrue(resultat>15);
	}
	
	@Test
	public void sommeDeuxString1() {
		
		int resultat = calc.somme("5","2");
		assertEquals(7, resultat);
	}
	
	@Test(expected=NumberFormatException.class)
	public void sommeDeuxString2() {
		
		double resultat = calc.somme("5.2","2.1");
		fail("Vous auriez du avoir une exception");
	}

	@Test(timeout=15000)
	public void sommeBeaucoupDeNombres() throws InterruptedException {
		
		double resultat = calc.somme(1, 3.4 , 5.4, 8, 4, 10, 10, 10);
		assertEquals(51.8, resultat, PRECISION);
	}
	
}
