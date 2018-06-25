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

import com.instainsurance.insuranceappl.daos.QuoteDao;
import com.instainsurance.insuranceappl.models.Quote;
import com.instainsurance.insuranceappl.models.Vehicle;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@Autowired
	private SessionFactory factory;
	
    @Override
	public Boolean insertQuote(Quote quote) {		
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(quote);
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
	public Boolean updateQuote(Quote quote) {
		
		return null;
	}

	@Override
	public Boolean deleteQuote(Quote quote) {
		
		return null;
	}

	@Override
	public Quote findByQuoteId(String id) {
		Session session= factory.openSession();
		Query query=session.createQuery("from Quote q where lower(q.quoteId) like:id")
				.setParameter("id", id.toLowerCase());
		Quote quote = (Quote)(query.list().get(0));
		
		//Vehicle vh = session.get(Vehicle.class, id);
		
		session.close();
		return quote;
	}

	@Override
	public List<Quote> getQuotes() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Quote");
		List <Quote>list = query.list();
		session.close();
		return list;
	}
}
