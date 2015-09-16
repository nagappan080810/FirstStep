package com.algorithm.sort;

import java.util.*;
public class SortClient {

	public static void main(String[] args) {
		// pass an array to quick sort util class.
		ArrayList<Integer> integerList = new ArrayList<Integer>(Arrays.asList(77, 63, 44, 55, 33, 22, 87));
		ArrayList<Character> charList = new ArrayList<Character>(Arrays.asList('t','a','u','m','r','q','b'));
		//sort using quick sort
		QuickSort.doQuickSort(integerList);
		QuickSort.doQuickSort(charList);
		//sort using merge sort
		ArrayList<Integer> integerList1 = new ArrayList<Integer>(Arrays.asList(77, 63, 44, 55, 33, 22, 87));
		ArrayList<Character> charList1 = new ArrayList<Character>(Arrays.asList('t','a','u','m','r','q','b'));
		MergeSort m1 = new MergeSort();
		m1.doSort(integerList1);
		m1.doSort(charList1);
		//assert statment example.
		for(int i = 1; i < 3; i++)
			for(int j = 3; j >= 1; j--)
				assert i!=j:i;
	}

}
