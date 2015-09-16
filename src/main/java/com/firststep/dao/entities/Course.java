package com.firststep.dao.entities;
import javax.persistence.*;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import java.util.*;
@Entity
@Table(name="course")
public class Course {
	@Id 
	private int courseId;
	private String courseName;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="course")
	@OrderBy("studentName")
	private List<Student> students;
	public Course(){}
	public Course(int courseId, String courseName){
		this.courseId = courseId;
		this.courseName = courseName;
	}
	public void addStudent(Student s){
		if (students == null)
			students = new ArrayList<Student>();
		this.students.add(s);
	}
	public List<String> getStudentNames(){
		Iterator it = students.iterator();
		List<String> studentNames = new ArrayList<String>();
		while(it.hasNext())
		{
			studentNames.add(((Student) it.next()).getStudentName());
		}
		return studentNames;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCoureName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ ", students=" + students + "]";
	} 
	
}
