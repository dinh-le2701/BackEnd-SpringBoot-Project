package com.dinhle.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dinhle.todolist.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	@Query(value = "select task_name from Tasks task_name")
	Task findByName(String task_name);
}
