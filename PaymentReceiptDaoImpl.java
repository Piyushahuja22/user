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

import com.instainsurance.insuranceappl.daos.PaymentReceiptDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.PaymentReceipt;


@Repository
public class PaymentReceiptDaoImpl implements PaymentReceiptDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public Boolean insertPaymentReceipt(PaymentReceipt paymentReceipt) throws InsuranceException {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(paymentReceipt);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the payment receipt", e);
		} finally {
			session.close();
		}
		return flag;
	}
	
	

	@Override
	public List<PaymentReceipt> getPaymentReceipts() throws InsuranceException {
		Session session = factory.openSession();
		Query query =session.createQuery("from PaymentReceipt");
		List <PaymentReceipt>list = query.list();
		session.close();
		return list;
	}

	}   
	
