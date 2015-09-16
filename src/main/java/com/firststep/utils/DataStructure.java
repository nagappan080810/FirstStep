package com.firststep.utils;

import java.util.Arrays;

public class DataStructure {

	public static void main(String[] args) {
		System.out.println("2nd row attr2 value is "+getValueForKey(2, "attr2"));
		}

	private static String getValueForKey(int row, String key){
		String keysDomain[] = new String[]{"attr1", "attr2", "attr3"};
		//if keysDomain is not in the same order, then while adding the value to valuesDomain, 
		//check for the attribute postion and then put the value in that postion
		//if attr3, then position is 3 so it should be put in valuesDomain. 
		String valuesDomain[][] = new String [][]{{"value11","value12","value13"},
												  {"value21","value22","value23"},
												  {"value31","value32","value33"}};
		int keyPosition = Arrays.binarySearch(keysDomain, key);
		return valuesDomain[row-1][keyPosition];
	}
}