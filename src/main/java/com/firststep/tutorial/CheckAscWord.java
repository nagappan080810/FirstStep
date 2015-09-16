package com.firststep.tutorial;

import java.util.Scanner;

public class CheckAscWord {

	public static void main( String args[] )
	{
	    System.out.print( "#Please enter a name : " );
	    Scanner in = new Scanner(System.in);
	    String name = in.next();
	    while(!name.equals("END")){

	        Boolean inOrder = true;

	            String nameLC = name.toLowerCase();
	            char previous = name.charAt(0);
	            for (int x = 0; x < nameLC.length() && inOrder ; x++) {
	                inOrder = nameLC.charAt(x) >= previous;
	                // inOrder must only be set false
	                previous = nameLC.charAt(x);
	            }

	            // The problem is you only want to set inOrder to be false
	            // If you set it to true as well then you will cancel out
	            // a possible previous finding of that two letters were out of order


	            if (inOrder && !name.equals("END"))
	            {
	                System.out.print(name + "\t" + "letters in ascending order");
	            }
	            else if (!inOrder && !name.equals("END"))
	            {   
	                System.out.print(name + "\t" + "letters not in ascending order");
	            }

	            System.out.print("\n");

	            System.out.print("#Please enter a name : ");
	            name = in.next();

	    }
	}
}
