package com.niit.todolist.dao;

import java.util.List;

import com.niit.todolist.model.TaskDetails;

public interface TaskDAO {

	public void addTask(TaskDetails taskDetails);

	public void updateTask(TaskDetails taskDetails);
	
	public List<TaskDetails> getTaskList();

}
