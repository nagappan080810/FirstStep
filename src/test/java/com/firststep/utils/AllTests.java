package com.firststep.utils;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ArithmeticCalcTest.class);
		suite.addTestSuite(ArithmeticCalcTest2.class);
		//$JUnit-END$
		return suite;
	}
}