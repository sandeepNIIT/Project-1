package com.niit.mycartbackendproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mycartbackendproject.model.Login;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Login UserToDelete = new Login();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);

	}

	@Transactional
	public List<Login> list() {
		@SuppressWarnings("unchecked")
		List<Login> listUser = (List<Login>) sessionFactory.getCurrentSession().createCriteria(Login.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Transactional
	public void save(Login login) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(login);

	}

	@Transactional
	public void Update(Login login) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(login);

	}

	@Transactional
	public Login get(int id) {
		String hql = "from Login where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Login> listUser = query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public boolean isValidUser(String name, String password) {
		String hql = "from Login where name= '" + name + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Login> list = (List<Login>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}

	
}
