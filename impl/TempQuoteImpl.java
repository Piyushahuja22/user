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

import com.instainsurance.insuranceappl.daos.TempQuoteDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.Quote;
import com.instainsurance.insuranceappl.models.TempQuote;
import com.instainsurance.insuranceappl.models.Vehicle;

@Repository
public class TempQuoteImpl implements TempQuoteDao {

	@Autowired
	private SessionFactory factory;   
	
	@Override
	public Boolean insertTempQuote(TempQuote tempQuote) throws InsuranceException {
		System.out.println("Here"+tempQuote);
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(tempQuote);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the temporary quote.", e);
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateTempQuote(TempQuote tempQuote) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(tempQuote);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the temporary quote.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteTempQuote(TempQuote tempQuote) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		System.out.println("Dao delete"+tempQuote);
		try {
			tn.begin();
			session.delete(tempQuote);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the temporary quote.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public TempQuote findByTempQuoteId(String id) throws InsuranceException {
		TempQuote q;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from TempQuote q where lower(q.customerEmail) like:id")
					.setParameter("id", id.toLowerCase());
			q = (TempQuote)(query.list().get(0));
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new InsuranceException("Problem in finding the temporary quote.", e);
		}
		return q;
	}	
	

	@Override
	public List<TempQuote> getTempQuotes() {
		Session session = factory.openSession();
		Query query = session.createQuery("from TempQuote");
		List <TempQuote>list = query.list();
		session.close();
		return list;
	}

}
