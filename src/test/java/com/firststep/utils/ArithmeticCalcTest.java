package com.firststep.utils;

import junit.framework.TestCase;

public class ArithmeticCalcTest extends TestCase {
	private ArithmeticCalc calc1;

	public ArithmeticCalcTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		calc1 = new ArithmeticCalc();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		calc1 = null;
	}
	
	public void testAdd(){
		
		int a = calc1.addition(5, 3);
		assertEquals("Expected value is 8",8, a );
	}
	public void testMultiply(){
		int a = calc1.multiply(5, 4);
		assertTrue("Product should be 20",a==20);
		
	}
}
