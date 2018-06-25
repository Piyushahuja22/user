package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instainsurance.insuranceappl.daos.CustomerDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.Customer;
import com.instainsurance.insuranceappl.models.Vehicle;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory factory;
    
	@Override
	public Boolean insertCustomer(Customer customer) throws InsuranceException {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(customer);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in registering the customer.", e);
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateCustomer(Customer customer) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(customer);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the details of the customer.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteCustomer(Customer customer) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.delete(customer);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the customer.", e);
		} finally {
		session.close();
		}
		return flag;
	}


	@Override
	public List<Customer> getCustomer() throws InsuranceException {
		Session session = factory.openSession();
		Query query = session.createQuery("from Customer");
		List <Customer>list = query.list();
		session.close();
		return list;
	}

	@Override
	public Customer findByCustomerId(String userName) throws InsuranceException {
		Customer customer;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from Customer as c where c.customerEmail=?")
					.setParameter(0, userName.toLowerCase());
			customer = (Customer)(query.list().get(0));
			session.close();			
		} catch (HibernateException e) {
			throw new InsuranceException("Customer doesn't exist", e);
		}
		return customer;
	}

}
