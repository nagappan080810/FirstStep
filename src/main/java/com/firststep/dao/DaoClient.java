package com.firststep.dao;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.firststep.dao.pojo.CallLog;

public class DaoClient {
	public static void main(String args[]){
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("daocontext.xml");
		CallLogDao callLogDao = (CallLogDao) ac.getBean("callLogDao");
		if(callLogDao==null) System.out.println("call log dao retrieved null");
		//alias to bean example
		//callLogDao.readUniqueDestinationNumberList();
		//read unique destination number
		callLogDao.readUniqueDestinationNumberList2();
		//saving a record in calllog
//		Double src = new Double("9629230494");
//		Double dest = new Double("8870184532");
//		CallLog callLog = new CallLog(1, src, dest);
//		callLogDao.save(callLog);
		//ac.close();
	}

	
}
