package com.firststep.dao.entities;
import java.io.*;

import javax.persistence.*;

import org.springframework.cglib.beans.BeanCopier.Generator;
@Embeddable
public class TaskItemKey implements Serializable{
	/**
	 * composite primary key of task items tables.
	 */
	private static final long serialVersionUID = 1L;
	private int tid;
	private int eid;
	public TaskItemKey(){}
	public TaskItemKey(int tid, Employee employee){
		this.tid = tid;
		//this.eid = 1; //temp check
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "TaskItemKey [tid=" + tid + ", eid=" + eid + "]";
	}
	
}
