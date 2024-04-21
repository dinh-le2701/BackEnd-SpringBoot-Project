package com.dinhle.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinhle.todolist.model.Task;
import com.dinhle.todolist.service.TaskService;

import org.springframework.util.MimeType;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	// get task list
	@GetMapping("")
	public ResponseEntity<List<Task>> getTasks(){
		List<Task> tasks = taskService.getAllTask();
		return ResponseEntity.ok(tasks);
	}
	
	// update task by id
//	@GetMapping("/{task_id}")
//	public ResponseEntity<Task> getTaskById(@PathVariable Integer task_id, @){
//		Task task = taskService.getTaskById(task_id);
//		return ResponseEntity.ok(task);
//	}
	
	// get task by name
	@GetMapping("/{task_name}")
	public ResponseEntity<Task> getTaskByName(@PathVariable String task_name){
		Task task = taskService.getTaskByName(task_name);
		return ResponseEntity.ok(task);
	}
	
	// create new task
	@PostMapping(value = "", produces = "application/vnd.baeldung.api.v1+json")
	public ResponseEntity<Task> creteNewTask(@RequestBody Task task){
		Task createTask = taskService.createNewTask(task);
		return ResponseEntity.ok(createTask);
	}
	
	// update task by id
	@PutMapping("/{task_id}")
	public ResponseEntity<Task> updateTask(@PathVariable Integer task_id, @RequestBody Task task){
		Task updateTask = taskService.updateTask(task_id, task);
		return ResponseEntity.ok(updateTask);
	}
	
	// delete task by id
	@DeleteMapping("/{task_id}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer task_id){
		try {
			taskService.deleteTask(task_id);
			return new ResponseEntity<>("Deleted!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
