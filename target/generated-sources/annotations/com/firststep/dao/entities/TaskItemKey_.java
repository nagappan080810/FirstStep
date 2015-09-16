package com.firststep.dao.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TaskItemKey.class)
public abstract class TaskItemKey_ {

	public static volatile SingularAttribute<TaskItemKey, Integer> tid;
	public static volatile SingularAttribute<TaskItemKey, Integer> eid;

}

