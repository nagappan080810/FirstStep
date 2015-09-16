package com.spring.scheduler.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchedulerDemo {

	public static void main(String[] args) throws InterruptedException {
		// Scheduler demo
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyScheduler myScheduler = (MyScheduler) ac.getBean("myScheduler");
		myScheduler.startSchedule();
		System.out.println("Main Thread completed");
		//Thread.sleep(10000);
	}

}
