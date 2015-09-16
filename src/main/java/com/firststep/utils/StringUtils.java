package com.firststep.utils;

import java.io.Console;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static void main(String[] args) {
		String source = new String("this is t-p and f-policy");
		System.out.println("value is " + Pattern.compile("\\bt\\-p\\b").matcher(source).find());
		
		String upperCaseString = new String("ABCDEABCDEABCDEAE");
		System.out.println("value is " + Pattern.compile("([A-Z&&[^IOQ]]){17}").matcher(upperCaseString).matches());
		
		String upperCaseString1 = new String("A");
		System.out.println("value is " + Pattern.compile("([A-Z]){1}").matcher(upperCaseString).find());
		
		 Pattern pattern = 
		            Pattern.compile("\\bt\\-p\\b");

		            Matcher matcher = 
		            pattern.matcher("this is working t-p  and f-policy ball-pen test-p string");
		            
		            boolean found = false;
		            while (matcher.find()) {
		                System.out.printf("I found the text" +
		                    " \"%s\" starting at " +
		                    "index %d and ending at index %d.%n",
		                    matcher.group(),
		                    matcher.start(),
		                    matcher.end());
		                found = true;
		            }
		            if(!found){
		                System.out.printf("No match found.%n");
		            }

	}

}