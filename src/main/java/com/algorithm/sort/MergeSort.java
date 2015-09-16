package com.algorithm.sort;
import java.util.*;

public class MergeSort implements Sort {
	public <T> List<T> doSort(ArrayList<T> sortArray){
		System.out.println("printing array elements before merge sort:");		
		printArray(sortArray);
		List<T> resultArray = splitandmergeArray(sortArray);
		System.out.println("printing array elements after nerge sort:");		
		printArray(resultArray);
		return resultArray;
	}
	private <T> void printArray(List<T> sortArray){
		Iterator<T> it = sortArray.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+",");
		}
		System.out.println();
	}
	private <T> List<T> splitandmergeArray(List<T> sortArray){
		int startindex = 0;
		int lastindex = sortArray.size() - 1;
		if ((lastindex - startindex) ==0)//if there is only one element just return without split.
			return sortArray;
		int mid = ((lastindex-startindex)/2);
		System.out.println("startindex "+startindex+" lastindex "+lastindex+" mid "+mid+" size "+sortArray);
		List<T> sortArray1 = splitandmergeArray(sortArray.subList(startindex, mid+1));
		List<T> sortArray2 = splitandmergeArray(sortArray.subList(mid+1, lastindex+1));
		List<T> sortArray3 = sortandmergeArray(sortArray1, sortArray2);
		return sortArray3;
	}
	private <T> List<T> sortandmergeArray(List<T> sortArray1, List<T> sortArray2){
		ListIterator<T> it1 = sortArray1.listIterator();
		ListIterator<T> it2 = sortArray2.listIterator();
		List<T> resultArray = new ArrayList<T>();
		while((it1.hasNext())||(it2.hasNext())){
			if (it1.hasNext() && it2.hasNext()){
				T e1 = it1.next();
				T e2 = it2.next();
				if (compare(e1, e2)<0)
				{
					resultArray.add(e1);
					it2.previous();
				}
				else
				{
					resultArray.add(e2);
					it1.previous();
				}
				continue;
			}
			if (it1.hasNext()){//excess elements in left sub list are appended to result
				resultArray.add(it1.next());
			}
			if (it2.hasNext()){//excess elements in right sub list are appended to result
				resultArray.add(it2.next());
			}
		}
		System.out.println("s1:"+sortArray1.size()+" s2:"+sortArray2.size()+" r:"+resultArray);
		return resultArray;
	}
	@Override
	public <T> int compare(T t1, T t2){
		@SuppressWarnings("unchecked")
		Comparable<T> t1comparable = (Comparable<T>) t1;
		return t1comparable.compareTo(t2);
	}

}
