package com.firststep.tutorial;

import java.util.Arrays;
import java.util.Scanner;


public class KeyboardReader {

	public static void main(String[] args) {
		String a = "";
		int count;
		Scanner keyboard = new Scanner(System.in);
		for (count = 0; count < 6; count++) {
		    System.out.println("Enter integer: ");
		    
		    if (keyboard.hasNextInt()) {  
		        System.out.println(keyboard.nextInt() + "is correct integer");
		        break;
		    }
		    else {
		        System.out.println("invalid input");
		        keyboard.next();
		    }
		}

	}

}