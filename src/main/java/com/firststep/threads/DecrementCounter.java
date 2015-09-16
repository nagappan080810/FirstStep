package com.firststep.threads;

public class DecrementCounter {
	public synchronized void decrement(){
		System.out.println("decrementing thread"+Thread.currentThread());
		for (int i = 5 ; i > 0; i--){
			System.out.println("decrement value"+ i);
		}
		System.out.println("thread eneded"+Thread.currentThread());
	}
}
