package com.firststep.dao.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SetAttribute<Employee, TaskItems> taskItems;
	public static volatile SingularAttribute<Employee, Integer> age;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, String> dept;

}

