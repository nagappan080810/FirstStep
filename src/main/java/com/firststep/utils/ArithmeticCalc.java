package com.firststep.utils;
/**
 * assert statement has been studied in the following main method 
 * it can be used for unit testing.
 * @author nagappan.s
 *
 */

public class ArithmeticCalc {
	public int addition(int a, int b){
		return (a+b);
	}
	public int subtract(int a, int b){
		return (a-b);
	}
	public int multiply(int a, int b){
		return (a*b);
	}
	public static void main(String args[]){
		ArithmeticCalc calc = new ArithmeticCalc();
		int o1= calc.addition(5, 3);
		System.out.println("value"+o1);
		//if condition is false, then exception thrown with given message after semicolon
		assert o1==7 : o1; 
		assert o1==8 : "unexpected value should be 8"; 
	}
}
