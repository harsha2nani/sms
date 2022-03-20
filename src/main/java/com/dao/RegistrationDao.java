package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.model.Login;

@Component
public class RegistrationDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveUser(Login login){
		
	 this.hibernateTemplate.save(login);
	
	}
	
	public List<Login> getAll(){
		return this.hibernateTemplate.loadAll(Login.class);
	}
	
	public  List<Login> check(){
		
		
		
		return this.hibernateTemplate.loadAll(Login.class);
	}

}
