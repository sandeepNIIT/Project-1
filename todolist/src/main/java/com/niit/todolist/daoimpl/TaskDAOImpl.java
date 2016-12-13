package com.niit.todolist.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.todolist.dao.TaskDAO;
import com.niit.todolist.model.TaskDetails;

@Repository("taskDAO")
public class TaskDAOImpl implements TaskDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;


	public TaskDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addTask(TaskDetails taskDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(taskDetails);
		
	}

	@Transactional
	public void updateTask(TaskDetails taskDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(taskDetails);
		
	}

	@Transactional
	public List<TaskDetails> getTaskList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TaskDetails");
		List<TaskDetails> taskList = query.list();
		session.flush();
		return taskList;
	}

}
