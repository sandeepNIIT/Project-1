package com.niit.mycartbackendproject.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mycartbackendproject.model.User;

@Repository("userDAO")

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void delete(int id) {
		User UserToDelete = new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}

	@Transactional
	public User get(int id) {
		String hql = "from User where id =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = (List<User>) query.getResultList();

		if (listUser != null && listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
	@Transactional
	public boolean isValidUser(String name,String password){
		String hql = "from User where name='"+name+"' and password = '"+password+"'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = (List<User>)query.getResultList();
		
		
		if( list.isEmpty()&&list==null){
			return false;}
			else{
				return true;
				}
		
		}
	
	@Transactional
	public boolean admin(String name,String password){
		String hql = "from User where name='Sandy@niit' and password ='admin@niit'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = (List<User>)query.getResultList();
		
		User useradmin = new User();
		if( list.isEmpty()){
			
			return false;
			}
			else{
				useradmin.setAdmin((byte) 1);
				return true;
				}
		
		}
	
	}


	

