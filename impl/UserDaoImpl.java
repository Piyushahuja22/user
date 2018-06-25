package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.instainsurance.insuranceappl.daos.UserDao;
import com.instainsurance.insuranceappl.models.User;
import com.instainsurance.insuranceappl.models.Vehicle;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;  
	
	@Override
	public Boolean insertUser(User user) {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(user);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateUser(User user) {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(user);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteUser(User user) {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.delete(user);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public User findByUserId(String id) {
		Session session= factory.openSession();
		Query query=session.createQuery("from User u where lower(u.userId) like:id")
				.setParameter("id", id.toLowerCase());
		User user = (User)(query.list().get(0));
		
		session.close();
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session session = factory.openSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		session.close();
		return list;
	}

}
