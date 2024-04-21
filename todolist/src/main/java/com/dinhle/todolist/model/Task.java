package com.dinhle.todolist.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int task_id;
	
	@Column(name = "task_name")
	private String task_name;
	
	@Column(name = "types")
	private String types;
	
	@Column(name = "create_at")
	private Date create_at;
	
	@Column(name = "active")
	private boolean active;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int task_id, String task_name, String types, Date create_at, boolean active) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.types = types;
		this.create_at = create_at;
		this.active = active;
	}
	
	
}
