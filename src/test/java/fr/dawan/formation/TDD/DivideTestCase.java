package fr.dawan.formation.TDD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

public class DivideTestCase {

	@Test
	public void testDivide() {
		Calculator calc = new Calculator();
		calc.setName("division");
		double resultat = calc.divide(6, 2);
		assertEquals(3, resultat, 0);
		assertThat(resultat, CoreMatchers.is(3.0));
		assertThat(calc, CoreMatchers.isA(Calculator.class));
		assertThat(calc, isADividingOperation());
	}
	
	public static Matcher<Calculator> isADividingOperation() {
		return new BaseMatcher<Calculator>() {
			
			public boolean matches(Object actual) {
				Calculator calc = (Calculator) actual;
				return calc.getName().startsWith("divi");
			}

			@Override
			public void describeMismatch(Object item, Description description) {
				Calculator calc = (Calculator) item;
				description.appendText("was : getName()="+calc.getName());
			}

			public void describeTo(Description description) {
				description.appendText("getName() starting with 'divi'");
				
			}
		};
		
	}

	
}
