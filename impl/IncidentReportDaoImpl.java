package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instainsurance.insuranceappl.daos.IncidentReportDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.IncidentReport;


@Repository
public class IncidentReportDaoImpl implements IncidentReportDao {
	@Autowired
	private SessionFactory factory;   
	
	@Override
	public Boolean insertIncidentReport(IncidentReport incidentReport) throws InsuranceException {
		System.out.println("Here"+incidentReport);
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(incidentReport);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the approved incident .", e);
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateIncidentReport(IncidentReport incidentReport) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(incidentReport);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the approved incident.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteIncidentReport(IncidentReport incidentReport) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		System.out.println("Dao delete"+incidentReport);
		try {
			tn.begin();
			session.delete(incidentReport);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the incident.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public IncidentReport findByIncidentReportId(String id) throws InsuranceException {
		IncidentReport ir;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from IncidentReport ir where lower(ir.incidentReportId) like:id")
					.setParameter("id", id.toLowerCase());
			ir = (IncidentReport)(query.list().get(0));
			session.close();
		} catch (HibernateException e) {
			throw new InsuranceException("Problem in finding the incident.", e);
		}
		return ir;
	}	
	

	@Override
	public List<IncidentReport> getIncidentReports() {
		Session session = factory.openSession();
		Query query = session.createQuery("from IncidentReport");
		List <IncidentReport>list = query.list();
		session.close();
		return list;
	}

}

