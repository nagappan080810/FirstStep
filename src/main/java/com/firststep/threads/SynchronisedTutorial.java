package com.firststep.threads;

public class SynchronisedTutorial {
	public static void main(String args[]){
		DecrementCounter decrementCounter = new DecrementCounter();
		DecrementDoer decrementDoer1 = new DecrementDoer("thread1",decrementCounter);
		DecrementDoer decrementDoer2 = new DecrementDoer("thread2",decrementCounter);
		decrementDoer1.start();
		decrementDoer2.start();
	}

}
