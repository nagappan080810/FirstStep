package com.firststep.tutorial;

import java.util.*;
public class HashSetUtil {
	public static void main(String args[]){
		ArrayList<String> knownList = new ArrayList<String>(Arrays.asList("known1","known2","known3"));
		ArrayList<String> errorList = new ArrayList<String>(Arrays.asList("known1","known2","NewError1","NewError2"));
		if (errorList.removeAll(knownList))
			System.out.println("new errors are - "+errorList);
		
	}

}
