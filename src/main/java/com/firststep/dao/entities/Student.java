package com.firststep.dao.entities;
import javax.persistence.*;
@Entity
@Table(name="student")
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private double marks;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="courseId",insertable=true, updatable=true)
	private Course course;
	public Student(){}
	public Student(int studentId, String studentName, double marks, Course course){
		this.studentId = studentId;
		this.studentName = studentName;
		this.marks = marks;
		this.course = course;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName="
				+ studentName + ", marks=" + marks + "]";
	}
	
	
}
