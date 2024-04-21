package com.dinhle.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinhle.todolist.model.Task;
import com.dinhle.todolist.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(int task_id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(task_id)
			.orElseThrow(() -> new RuntimeException("Not found task had id: " + task_id)); 
	}

	@Override
	public Task getTaskByName(String task_name) {
		// TODO Auto-generated method stub
		return taskRepository.findByName(task_name);
	}

	@Override
	public Task createNewTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Integer task_id, Task updateTask) {
		// TODO Auto-generated method stub
		Task task = taskRepository.findById(task_id)
				.orElseThrow(() -> new RuntimeException("Not found task had id: " + task_id));
		task.setTask_name(updateTask.getTask_name());
		task.setTypes(updateTask.getTypes());
		task.setCreate_at(updateTask.getCreate_at());
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Integer task_id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(task_id);
	}
	
	

}
