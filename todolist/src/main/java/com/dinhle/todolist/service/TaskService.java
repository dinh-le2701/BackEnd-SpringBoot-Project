package com.dinhle.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dinhle.todolist.model.Task;

@Service
public interface TaskService {
	
	List<Task> getAllTask();
	
	Task getTaskById(int task_id);
	
	Task getTaskByName(String task_name);
	
	Task createNewTask(Task task);
	
	Task updateTask(Integer task_id, Task task);
	
	void deleteTask(Integer task_id);
}
