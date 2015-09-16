package com.firststep.dao.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TaskItems.class)
public abstract class TaskItems_ {

	public static volatile SingularAttribute<TaskItems, TaskItemKey> taskItemKey;
	public static volatile SingularAttribute<TaskItems, Employee> employee;
	public static volatile SingularAttribute<TaskItems, String> taskName;
	public static volatile SingularAttribute<TaskItems, Integer> hoursreqd;

}

