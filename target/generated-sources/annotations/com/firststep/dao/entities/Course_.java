package com.firststep.dao.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile ListAttribute<Course, Student> students;
	public static volatile SingularAttribute<Course, Integer> courseId;
	public static volatile SingularAttribute<Course, String> courseName;

}

