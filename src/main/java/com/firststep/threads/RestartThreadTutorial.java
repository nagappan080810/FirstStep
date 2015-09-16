package com.firststep.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RestartThreadTutorial {

	public static void main(String args[]){
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<?> taskHandler =	executorService.submit(new Task());
		//restart the task after 5 seconds.
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			//empty
		}
		taskHandler.cancel(true);
		if (taskHandler.isCancelled()==true){
			executorService.submit(new Task());
		}
	}
	
	public static class Task implements Runnable{
		private int secondsCounter;
		@Override
		public void run(){
			while(true){
				System.out.println("Thread -"+Thread.currentThread().getName()+"elapsed - "+ (secondsCounter++) +"second");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
					break;
				}
			}
		}
	}
}
