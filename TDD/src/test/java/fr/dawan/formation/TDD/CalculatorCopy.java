package fr.dawan.formation.TDD;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class CalculatorCopy {
	
	@Test
	public void copieDeCalculator() {
		Calculator c1 = new Calculator();
		c1.setName("c1");
		Calculator c2 = new Calculator();
		c2.setName("c1");
		assertNotSame(c2, c1);
		assertNotEquals(c2, c1);
	}
	
}
