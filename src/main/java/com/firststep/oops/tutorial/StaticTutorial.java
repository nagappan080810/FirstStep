package com.firststep.oops.tutorial;

public class StaticTutorial {
	private static final String constClassLoadInitialization;
	static{
		constClassLoadInitialization = "value";
	}
	private static final String constCompilerTime = "value";
	
	private final String test;
	
	public static void main(String args[]){
		/*
		 * below expression is error - because the variable is not intialized at the defintion time itself.
		 */
//		switch(args[0]){
//			case constClassLoadInitialization:
//				System.out.println("constant class load initialized");
//		}
		switch(args[0]){
		case constCompilerTime:
			System.out.println("constant Compile time intialized");
		}
	}
	
	/**
	 * final class level variable should be intializated in the intialization block or the constructor block.  
	 */
	public StaticTutorial(){
		System.out.println("constructor");
	     test = "Hello";
	}

	/**
	 * final method local variable can be initalized at begining or middle of the method.
	 */
	public void method(){
		final int i;
		System.out.println("hello");
		i = 10;
	}
}