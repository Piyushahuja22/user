package com.instainsurance.insuranceappl.daos.impl;

import java.util.List;


import com.instainsurance.insuranceappl.daos.VehicleDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.Vehicle;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory factory;     
	
	@Override
	public Boolean insertVehicle(Vehicle vehicle) throws InsuranceException {
		Session session=factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(vehicle);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in registering the vehicle.", e);
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateVehicle(Vehicle vehicle) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {
			tn.begin();
			session.update(vehicle);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the vehicle details.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteVehicle(Vehicle vehicle) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		System.out.println("Dao delete"+vehicle);
		try {
			tn.begin();
			session.delete(vehicle);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the vehicle.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Vehicle findByVehicleId(String id) throws InsuranceException {
		Vehicle vehicle;
		try {
			Session session= factory.openSession();
			Query query=session.createQuery("from Vehicle v where lower(v.vehicleRegNo) like:id")
					.setParameter("id", id.toLowerCase());
			vehicle = (Vehicle)(query.list().get(0));
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new InsuranceException("Problem in finding the vehicle.", e);
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicles() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Vehicle");
		List <Vehicle>list = query.list();
		session.close();
		return list;
	}

}
