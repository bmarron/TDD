package fr.dawan.formation.TDD;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DivideTestCase.class, SommeTestCase.class })
public class CalculatorTests {

}
