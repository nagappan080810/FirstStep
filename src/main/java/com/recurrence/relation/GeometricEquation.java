package com.recurrence.relation;

public class GeometricEquation {
	public static void main(String args[]){
		int maxterm=5;
		int startno=3;
		double term = startno;
		System.out.printf("%.0f,",term);
		for (int i=1;i<maxterm;i++)
		{
			term = term*(2);
			System.out.printf("%.0f,",term);
		}
	}

}
