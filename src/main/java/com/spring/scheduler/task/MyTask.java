package com.spring.scheduler.task;
import java.util.Date;

public class MyTask implements Runnable{
	public void printMessage(){
		String currThread = Thread.currentThread().getName();
		System.out.println("**********************" + currThread +"****************************************");
		for (int i=0;i<10;i++){
			String currTime = new Date().toString();
			System.out.println(currTime+" - "+ currThread +" - "+ i +" - Printing Hello");
		}
		System.out.println("********************** Completed ****************************************");
	}
	public void run(){
		printMessage();
	}
}
