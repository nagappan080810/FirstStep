package com.firststep.tutorial;

public class YieldTutorial {
	public static class Thread1 extends Thread{
		private StringBuffer stringBuffer;
		public Thread1(StringBuffer stringBuffer){
			this.stringBuffer = stringBuffer;
		}
		public void run(){
			yield();
			stringBuffer.append("Hello");
		}
	}
	public static class Thread2 extends Thread{
		private StringBuffer stringBuffer;
		public Thread2(StringBuffer stringBuffer){
			this.stringBuffer = stringBuffer;
		}
		public void run(){
			yield();
			if(stringBuffer.indexOf("Hello")==-1)
			{
				System.out.println("world is not contactenated as hello word is missing");
			}
			stringBuffer.append("World");
		}
	}
	public static void main(String args[]){
		StringBuffer stringBuffer = new StringBuffer();
		Thread1 t1 = new Thread1(stringBuffer);
		Thread2 t2 = new Thread2(stringBuffer);
		t1.start();
//		try{
//		t1.join();
//		}catch(Exception e){	
//		}
		t2.start();
		try{
		t2.join();
		}catch(Exception e){
			
		}
		System.out.println(stringBuffer);
	}

}
