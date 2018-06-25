package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instainsurance.insuranceappl.daos.IncidentDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.Incident;

@Repository
public class IncidentDaoImpl implements IncidentDao {
	
	@Autowired
	private SessionFactory factory;   

	@Override
	public Boolean insertIncident(Incident incident) throws InsuranceException {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(incident);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the incident.", e);
		} finally {
			session.close();
		}
		return flag;
		}

	@Override
	public Boolean updateIncident(Incident incident) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(incident);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the incident.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteIncident(Incident incident) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		System.out.println("Dao delete"+incident);
		try {
			tn.begin();
			session.delete(incident);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
				throw new InsuranceException("Problem in deleting the incident.", e);
			}
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Incident findByIncidentId(String id) throws InsuranceException {
		Incident i;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from Incident i where lower(i.incidentId) like:id")
					.setParameter("id", id.toLowerCase());
			i = (Incident)(query.list().get(0));
			session.close();
		} catch (HibernateException e) {
			throw new InsuranceException("Problem in finding the incident.", e);
		}
		return i;
	}

	@Override
	public List<Incident> getIncidents() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Incident");
		List<Incident> list = query.list();
		session.close();
		return list;
	}

}
