package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instainsurance.insuranceappl.daos.PolicyDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.Policy;

@Repository
public class PolicyDaoImpl implements PolicyDao {

	@Autowired
	private SessionFactory factory;     
	
	@Override
	public Boolean insertPolicy(Policy policy) throws InsuranceException {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(policy);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the policy.", e);
		} finally {
			session.close();
		}
		return flag;
	}
	

	@Override
	public Boolean updatePolicy(Policy policy) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(policy);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the policy.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deletePolicy(Policy policy) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.delete(policy);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the policy.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Policy findByPolicyId(String id) throws InsuranceException {
		Policy policy;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from Policy p where lower(p.policyId) like:id")
					.setParameter("id", id.toLowerCase());
			policy = (Policy)(query.list().get(0));
			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new InsuranceException("Problem in finding the policy.", e);
		}
		return policy;
	}

	@Override
	public List<Policy> getPolicies() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Policy");
		List <Policy>list = query.list();
		session.close();
		return list;
	}
	
	@Override
	public List<Policy> getPoliciesByCategory(String category) {
		Session session = factory.openSession();	
		Query query=session.createQuery("from Policy p where p.policyCategory like:id").setParameter("id", category);		
		List<Policy> list = query.list();	
		session.close();
		return list;
	}

}
