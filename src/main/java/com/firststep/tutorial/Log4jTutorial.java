package com.firststep.tutorial;

import org.apache.log4j.Logger;

public class Log4jTutorial {
	protected Log4jTutorial(){
		System.out.println("protected constructor");
	}
	static Logger log = Logger.getLogger(Log4jTutorial.class.getName());
	public static void main(String args[]){
		
		log.debug("this is a debug message");
		log.info("this is info message");
		log.info("now testing for properties over precedence");
		DumpLogs d1 = new DumpLogs();
		d1.dumplogs();
		System.out.println("completed");
		
	}

}
