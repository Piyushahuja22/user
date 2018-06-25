/**
 * 
 */
package com.instainsurance.insuranceappl.daos.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.instainsurance.insuranceappl.daos.VehiclesDataDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.VehiclesData;

@Repository
public class VehiclesDataDaoImpl implements VehiclesDataDao {
	
	@Autowired
	private SessionFactory factory;  

	@Override
	public Boolean insertVehicleData(VehiclesData vehicleData) throws InsuranceException {
		Session session = factory.openSession(); 
		Transaction tn = session.getTransaction();	
		Boolean flag = false;
		try {
			tn.begin();
			session.persist(vehicleData);
			tn.commit();
			flag = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tn != null) {
				tn.rollback();		
			}
			throw new InsuranceException("Problem in inserting the static vehicle data.", e);
		} finally {
			session.close();
		}
		return flag;
	}
	

	@Override
	public Boolean updateVehicleData(VehiclesData vehicleData) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		try {			
			tn.begin();
			session.update(vehicleData);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in updating the static vehicle data.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public Boolean deleteVehicleData(VehiclesData vehicledata) throws InsuranceException {
		Session session=factory.openSession();
		Transaction tn = session.getTransaction();
		Boolean flag = false;
		System.out.println("Dao delete"+vehicledata);
		try {
			tn.begin();
			session.delete(vehicledata);
			tn.commit();
			flag = true;
		} catch (HibernateException e) {
			if(tn!=null) {
				System.out.println("Error Occurred : "+ e.getMessage());
				tn.rollback();
			}
			throw new InsuranceException("Problem in deleting the static vehicle data.", e);
		} finally {
		session.close();
		}
		return flag;
	}

	@Override
	public VehiclesData findByVehicleDataId(String id) throws InsuranceException {
		VehiclesData vehicleData;
		try {
			Session session= factory.openSession();
			Query query = session.createQuery("from VehiclesData v where lower(v.vehiclesMakerName) like:id")
					.setParameter("id", id.toLowerCase());
			vehicleData = (VehiclesData) (query.list().get(0));

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new InsuranceException("Problem in finding the static vehicle data.", e);
		}
		return vehicleData;
	}
}
