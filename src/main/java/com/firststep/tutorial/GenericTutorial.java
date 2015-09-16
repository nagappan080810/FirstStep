package com.firststep.tutorial;
import java.util.*;

public class GenericTutorial {

	public static void main(String[] args) {
		// To check list without parameterized type allows objects ?
		List a = new ArrayList();
		a.add("test");
		a.add(23);
		a.add(53.23f);
		System.out.println("list values"+a);
		for (Object element:a){
			if (element instanceof Integer)
				System.out.println("element - "+element.toString()+" is a integer");
		}
	}

}
