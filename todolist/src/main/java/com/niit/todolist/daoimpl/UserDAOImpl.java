package com.niit.todolist.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.todolist.dao.UserDAO;
import com.niit.todolist.model.UserDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addUser(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);

	}

	@Transactional
	public void updateUser(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);

	}

	@Transactional
	public void deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(userId);
		session.flush();

	}

	@Transactional
	public List<UserDetails> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserDetails");
		List<UserDetails> userList = query.list();
		session.flush();
		return userList;
	}

}
