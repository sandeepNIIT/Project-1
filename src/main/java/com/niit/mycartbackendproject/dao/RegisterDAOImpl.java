package com.niit.mycartbackendproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mycartbackendproject.model.Login;
import com.niit.mycartbackendproject.model.Register;

@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(Register register)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(register);
		
	}
	
	@Transactional
	public void delete(int id) {
		
		Register UserToDelete = new Register();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}
	@Transactional
	public List<Register> list() {
		@SuppressWarnings("unchecked")
		List<Register> list = (List<Register>) sessionFactory.getCurrentSession().createCriteria(Register.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}
	
	@Transactional
	public Register get(int id) {
		String hql = "from Register where id=" + "'" + id + "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Register> listUser =query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	@Transactional
	public boolean isValidUser(String name, String password) {
		String hql = "from Register where name= '" + name + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		
		List<Login> list = (List<Login>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
