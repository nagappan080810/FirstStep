package com.firststep.utils;

import junit.framework.TestCase;

public class ArithmeticCalcTest2 extends TestCase {
	private ArithmeticCalc arithmeticCalc;
	public ArithmeticCalcTest2(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		arithmeticCalc = new ArithmeticCalc();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		arithmeticCalc = null;
		super.tearDown();
	}
	
	public void testSubtract(){
		int a = arithmeticCalc.subtract(3, 2);
		assertTrue("assert equals to 1",a!=1);
	}
}
