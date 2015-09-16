package com.firststep.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;

import com.firststep.dao.*;
import com.firststep.dao.entities.*;

import java.util.*;
@Service
public class CourseService {
	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public void addCourses(){
		Course c1 = new Course(1,"Zoology");
		Student s0 = new Student(1, "Zenitha", 78,c1);
		Student s1 = new Student(2, "Kannan", 55,c1);
		Student s2 = new Student(3, "Muthu", 63,c1);
		Student s3 = new Student(4, "Kumaran", 43,c1);
		c1.addStudent(s0);c1.addStudent(s1);c1.addStudent(s2);c1.addStudent(s3);
		Course c2 = new Course(2,"Geology");
		Student s4 = new Student(5, "Guru", 55,c2);
		Student s5 = new Student(6, "Nanda", 63,c2);
		Student s6 = new Student(7, "Vel", 43,c2);
		c2.addStudent(s4);c2.addStudent(s5);c2.addStudent(s6);
		courseDao.add(c1);courseDao.add(c2);
	}
	public void displayCourseStudents(String courseName){
		List<String> studentList = courseDao.readCourseStudent(courseName);
		System.out.println("students are "+studentList);
	}
	public static void main(String args[]){
		ApplicationContext ac = new ClassPathXmlApplicationContext("daocontext.xml");
		CourseService courseService = (CourseService) ac.getBean("courseService"); 
		courseService.addCourses();
		courseService.displayCourseStudents("Zoology");
	}
}
