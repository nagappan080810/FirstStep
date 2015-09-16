package com.spring.scheduler.task;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaSchedulerDemo {

	public static void main(String[] args) {
		// Schedule a task using only Java ThreadExecutor
		System.out.println("Main Thread started");
		MyTask myTask = new MyTask();
		int corePoolSize = 5;
		ScheduledThreadPoolExecutor myExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
		//myExecutor.scheduleAtFixedRate(myTask, 1000, 2000, TimeUnit.MILLISECONDS);
		myExecutor.scheduleAtFixedRate(myTask, 0, 1, TimeUnit.DAYS);
		System.out.println("Main Thread ended");
	}

}
