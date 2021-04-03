package training.oracle.tms.dao.impl;

import java.util.List;

import org.hibernate.Session;

import training.oracle.tms.dao.VehicleDetailsDAO;
import training.oracle.tms.entities.VehicleDetailsEO;
import training.oracle.tms.util.HibernateUtil;

public class VehicleDetailsDAOImpl implements VehicleDetailsDAO {

	@Override
	public Integer insertDetails(VehicleDetailsEO vehicleDetailsEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		Integer returnedPK = (Integer)sessionRef.save(vehicleDetailsEORef);
		sessionRef.getTransaction().commit();
		sessionRef.close();		
		return returnedPK;
	}

	@Override
	public void updateDetails(VehicleDetailsEO vehicleDetailsEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		VehicleDetailsEO vehicleDetailsEOToBeUpdated = (VehicleDetailsEO)sessionRef.get(VehicleDetailsEO.class, vehicleDetailsEORef.getVehId());
		vehicleDetailsEOToBeUpdated.setVehName(vehicleDetailsEORef.getVehName());
		vehicleDetailsEOToBeUpdated.setVehType(vehicleDetailsEORef.getVehType());
		vehicleDetailsEOToBeUpdated.setVehColor(vehicleDetailsEORef.getVehColor());
		vehicleDetailsEOToBeUpdated.setCubicCapacity(vehicleDetailsEORef.getCubicCapacity());
		vehicleDetailsEOToBeUpdated.setDateOfManufacture(vehicleDetailsEORef.getDateOfManufacture());
		vehicleDetailsEOToBeUpdated.setEngineNo(vehicleDetailsEORef.getEngineNo());
		vehicleDetailsEOToBeUpdated.setFuelUsed(vehicleDetailsEORef.getFuelUsed());
		vehicleDetailsEOToBeUpdated.setManufacturerName(vehicleDetailsEORef.getManufacturerName());
		vehicleDetailsEOToBeUpdated.setModelNo(vehicleDetailsEORef.getModelNo());
		vehicleDetailsEOToBeUpdated.setNoOfCylinders(vehicleDetailsEORef.getNoOfCylinders());
		sessionRef.update(vehicleDetailsEOToBeUpdated);
		sessionRef.getTransaction().commit();
		sessionRef.close();
	}

	@Override
	public void deleteDetails(Integer vehicleID) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		VehicleDetailsEO vehicleDetailsEO = (VehicleDetailsEO)sessionRef.get(VehicleDetailsEO.class,vehicleID);
		sessionRef.delete(vehicleDetailsEO);
		sessionRef.getTransaction().commit();
		sessionRef.close();
	}

	@Override
	public VehicleDetailsEO findByVehicleID(Integer vehicleID) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		VehicleDetailsEO vehicleDetailsEO = (VehicleDetailsEO)sessionRef.get(VehicleDetailsEO.class, vehicleID);
		sessionRef.close();
		return vehicleDetailsEO;
	}

	@Override
	public List<VehicleDetailsEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
