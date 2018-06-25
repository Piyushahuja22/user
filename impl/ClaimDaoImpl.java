package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instainsurance.insuranceappl.daos.ClaimDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.Claim;

@Repository
public class ClaimDaoImpl implements ClaimDao{

	@Autowired
	private SessionFactory factory;   

	@Override
	public Boolean insertClaim(Claim claim) throws InsuranceException {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(claim);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the claim.", e);
		} finally {
			session.close();
		}
		return flag;
		}

	@Override
	public Boolean updateClaim(Claim claim) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(claim);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the claim.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteClaim(Claim claim) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		System.out.println("Dao delete"+claim);
		try {
			tn.begin();
			session.delete(claim);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the claim.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Claim findByClaimId(String id) throws InsuranceException {
		Claim c;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from Claim c where lower(c.claimId) like:id")
					.setParameter("id", id.toLowerCase());
			c = (Claim)(query.list().get(0));
			session.close();
		} catch (HibernateException e) {
			throw new InsuranceException("Claim does not exist", e);
		}
		return c;
	}

	@Override
	public List<Claim> getClaims() throws InsuranceException {
		Session session = factory.openSession();
		Query query =session.createQuery("from Claim");
		List <Claim>list = query.list();
		session.close();
		return list;
	}

}
