package test;

import static org.junit.Assert.*;
import org.junit.Test;


import  main.Calculator;

public class CalculatorTest {

	@Test
	public final void testDiv() {
		assertTrue(3==Calculator.div(6, 2));
	}

	@Test
	public final void testMult() {
		assertTrue(12==Calculator.mult(6, 2));
	}

	@Test
	public final void testAdd() {
		assertTrue(8==Calculator.add(6, 2));
	}

	@Test
	public final void testSub() {
		assertTrue(4==Calculator.sub(6, 2));
	}

}
