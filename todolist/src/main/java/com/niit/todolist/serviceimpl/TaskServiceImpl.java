package com.niit.todolist.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.todolist.dao.TaskDAO;
import com.niit.todolist.model.TaskDetails;
import com.niit.todolist.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO taskDAO;

	public void addTask(TaskDetails taskDetails) {
		taskDAO.addTask(taskDetails);
	}

	public void updateTask(TaskDetails taskDetails) {
		taskDAO.updateTask(taskDetails);
	}

	public List<TaskDetails> getTaskList() {
		return taskDAO.getTaskList();
	}

}