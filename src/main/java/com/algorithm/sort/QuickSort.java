package com.algorithm.sort;
import java.util.*;
public class QuickSort {
	// place the pilot element at partition index where left side elements are
	// less, right side element are more.
	private static <T> ArrayList<T> doPartition(ArrayList<T> sortarray, int minindex, int maxindex) {
		// choose first element as pilot
		int pilot = minindex;
		// mark the lower & upper limit
		int lb = pilot + 1;
		int ub = maxindex - 1;
		while (true) {
			if (compare(sortarray.get(lb),sortarray.get(pilot))<0)
			//if (sortarray[lb] < sortarray[pilot])
				lb++;// proceed if it less in left side
			if (compare(sortarray.get(pilot),sortarray.get(ub))<0)
				//if (sortarray[pilot] < sortarray[ub])
				ub--;// proceed if it greater in right side
			if (ub < lb)
				break;// break if upper crosses lower limit.
			// if pilot element matches with current lb element and lb & ub are
			// on same element, then exit as partition is completed.
			if ((compare(sortarray.get(pilot),sortarray.get(lb))==0) && (lb == ub))
			//if ((sortarray[pilot] == sortarray[lb]) && (lb == ub))
				break;
			// swap if left element is higher then right element
			if (compare(sortarray.get(lb),sortarray.get(ub))>0) {
			//if (sortarray[lb] > sortarray[ub]) {
				sortarray = swap(sortarray, lb, ub);
			}
		}
		// at the end, swap pilot with crossed upper index.
		sortarray = swap(sortarray, pilot, ub);
		System.out.println("partitioned at " + ub + " after partitioning ");
		printArray(sortarray);
		// left side sort
		if (ub - minindex > 1) {
			//System.out.println("sort left-part from " + minindex + " to " + ub);
			sortarray = doPartition(sortarray, minindex, ub);
		}
		// right side sort
		if (maxindex - ub - 1 > 1) {
			//System.out.println("sort right-part from " + ub + " to " + maxindex);
			sortarray = doPartition(sortarray, ub + 1, maxindex);
		}
		return sortarray;
	}
	//swap element at index 1 with element at index 2
	private static <T> ArrayList<T> swap(ArrayList<T> sortarray, int index1, int index2){
		T temp = sortarray.get(index2);
		sortarray.set(index2,sortarray.get(index1));
		sortarray.set(index1, temp);
		return sortarray;
	}
	private static <T> int compare(T t1, T t2){
		@SuppressWarnings("unchecked")
		Comparable<T> comparable = (Comparable<T>)t1;
		return comparable.compareTo(t2);
	}
	//print array elements in single line.
	private static <T> void printArray(ArrayList<T> sortarray) {
		Iterator<T> sortarrayIterator = sortarray.iterator();
		while (sortarrayIterator.hasNext()) {
			System.out.print(sortarrayIterator.next() + ",");
		}
		System.out.println();
	}
	//this is quick sort method exposed to client for sorting the array.
	public  static <T> ArrayList<T> doQuickSort(ArrayList<T> sortarray){
		System.out.print("before sorting array");
		printArray(sortarray);
		doPartition(sortarray, 0, sortarray.size());
		System.out.print("after sorting array");
		printArray(sortarray);
		return sortarray;
	}
//	public static void main(String args[]) {
//		QuickSort quickSorter = new QuickSort();
//		int[] sortarray = new int[] { 10, 9, 8, 5, 4, 3, 2, 4, 6, 1 };
//		// sorting array elements.
//		quickSorter.doQuickSort(sortarray);
//	}

}
