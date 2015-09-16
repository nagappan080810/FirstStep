package com.firststep.utils;

import java.util.*;

public class RemoveDuplicates {
	public static void main(String args[]){
		List<String[]> origList = new ArrayList<String[]>();
		
		TreeSet<String[]> set = new TreeSet<String[]>(new Comparator<String[]>() {
	        @Override
	        public int compare(String[] o1, String[] o2) {
	        	return Arrays.asList(o1).containsAll(Arrays.asList(o2))?0:1;
	        }});
	    set.addAll(origList);
		
	}

}
