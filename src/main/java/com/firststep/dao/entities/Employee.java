package com.firststep.dao.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	private String name;
	private int age;
	private String dept;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<TaskItems> taskItems;

	public Employee() {
	}

	public Employee(String name, int age, String dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}

	

	public Set<TaskItems> getTaskItems() {
		return taskItems;
	}
	public String getTaskItemsData() {
		String taskItemData = "";
		for(TaskItems taskItem:taskItems){
			taskItemData = taskItemData + taskItem.toStringItemOnly() + "\n";
		}
		return taskItemData;
	}
	
	

	public void setTaskItems(Set<TaskItems> taskItems) {
		this.taskItems = taskItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", dept=" + dept + ", taskItems=" + getTaskItemsData() +
				 "]";
	}

	public String toStringEmpDetails() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", dept=" + dept + "]";
	}

}
