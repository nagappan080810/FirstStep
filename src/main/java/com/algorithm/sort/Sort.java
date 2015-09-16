package com.algorithm.sort;
import java.util.*;
public interface Sort{
	public  <T> List<T> doSort(ArrayList<T> sortArray);
	public <T> int compare(T t1, T t2);
}
