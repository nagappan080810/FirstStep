package com.firststep.dao.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "taskitems")
public class TaskItems implements Serializable {
	@EmbeddedId
	@AttributeOverrides(
			{@AttributeOverride(name="tid",column=@Column(name="tid",nullable=false)),
			@AttributeOverride(name="eid",column=@Column(name="eid",nullable=false))}
	)
	private TaskItemKey taskItemKey;
	private String taskName;
	private int hoursreqd;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="eid",insertable=false, updatable=false)
	private Employee employee;

	public TaskItems() {
	}

	public TaskItems(int tid, String taskName, int hoursreqd, Employee employee) {
		this.taskItemKey = new TaskItemKey(tid, employee);
		this.taskName = taskName;
		this.hoursreqd = hoursreqd;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public TaskItemKey getTaskItemKey() {
		return taskItemKey;
	}

	public void setTaskItemKey(TaskItemKey taskItemKey) {
		this.taskItemKey = taskItemKey;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getHoursreqd() {
		return hoursreqd;
	}

	public void setHoursreqd(int hoursreqd) {
		this.hoursreqd = hoursreqd;
	}

	@Override
	public String toString() {
		return "TaskItems [taskItemKey=" + taskItemKey + ", taskName="
				+ taskName + ", hoursreqd=" + hoursreqd + "]";
	}

	public String toStringItemOnly() {
		return "TaskItems [taskItemkey=" + taskItemKey + ", taskName="
				+ taskName + ", hoursreqd=" + hoursreqd;
	}

}
