package com.firststep.dao.pojo;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CallLog.class)
public abstract class CallLog_ {

	public static volatile SingularAttribute<CallLog, Double> sourceNumber;
	public static volatile SingularAttribute<CallLog, Integer> callId;
	public static volatile SingularAttribute<CallLog, Double> destinationNumber;

}

