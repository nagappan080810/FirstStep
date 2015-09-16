package com.firststep.tutorial;

import org.apache.log4j.Logger;
public class DumpLogs {
	static Logger logger = Logger.getLogger(DumpLogs.class.getName());
	public void dumplogs(){
		System.out.println("Log4jTutorial"+DumpLogs.class.getName());
		logger.debug("Testing dump logs");
		logger.info("info message is switched");
	}
}
