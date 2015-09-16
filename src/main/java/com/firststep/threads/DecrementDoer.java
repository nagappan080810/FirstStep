package com.firststep.threads;

public class DecrementDoer extends Thread{
	DecrementCounter decrementCounter;
	public DecrementDoer(String threadName, DecrementCounter decrementCounter){
		super(threadName);
		this.decrementCounter = decrementCounter;
	}
	public void run(){
		decrementCounter.decrement();
	}

}
