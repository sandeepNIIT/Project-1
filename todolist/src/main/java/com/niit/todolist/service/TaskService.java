package com.niit.todolist.service;

import java.util.List;

import com.niit.todolist.model.TaskDetails;

public interface TaskService {

	public void addTask(TaskDetails taskDetails);

	public void updateTask(TaskDetails taskDetails);
	
	public List<TaskDetails> getTaskList();
	
	
}
