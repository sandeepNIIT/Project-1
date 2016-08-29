package com.niit.mycartbackendproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.dao.CategoryDAOImpl;
import com.niit.mycartbackendproject.dao.LoginDAO;
import com.niit.mycartbackendproject.dao.LoginDAOImpl;
import com.niit.mycartbackendproject.dao.ProductDAO;
import com.niit.mycartbackendproject.dao.ProductDAOImpl;
import com.niit.mycartbackendproject.dao.RegisterDAO;
import com.niit.mycartbackendproject.dao.RegisterDAOImpl;
import com.niit.mycartbackendproject.dao.SupplierDAO;
import com.niit.mycartbackendproject.dao.SupplierDAOImpl;

import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Login;
import com.niit.mycartbackendproject.model.Product;
import com.niit.mycartbackendproject.model.Register;
import com.niit.mycartbackendproject.model.Supplier;

@Configuration
@ComponentScan("com.niit.mycartbackendproject")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/mycartdb");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}

	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.show_sql","true");
	  properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		return properties;
		
	}
	@Autowired 
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Login.class);
		sessionBuilder.addAnnotatedClass(Register.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
