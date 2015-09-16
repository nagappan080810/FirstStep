package com.firststep.dao.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Course> course;
	public static volatile SingularAttribute<Student, Double> marks;
	public static volatile SingularAttribute<Student, Integer> studentId;
	public static volatile SingularAttribute<Student, String> studentName;

}

