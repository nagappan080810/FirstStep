package com.spring.scheduler.task;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;
public class MyScheduler {
	private MyTask myTask;
	private ScheduledThreadPoolExecutor myExecutor;
	
	public void startSchedule(){
		myExecutor.scheduleAtFixedRate(myTask, 1000, 2000, TimeUnit.MILLISECONDS);
	}
	public MyTask getMyTask() {
		return myTask;
	}
	public void setMyTask(MyTask myTask) {
		this.myTask = myTask;
	}
	public ScheduledThreadPoolExecutor getMyExecutor() {
		return myExecutor;
	}
	public void setMyExecutor(
			ScheduledThreadPoolExecutor myExecutor) {
		this.myExecutor = myExecutor;
	}
	

}
