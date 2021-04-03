package training.oracle.tms.dao.impl;

import java.util.List;

import org.hibernate.Session;

import training.oracle.tms.dao.OwnerDetailsDAO;
import training.oracle.tms.entities.OwnerDetailsEO;
import training.oracle.tms.util.HibernateUtil;

public class OwnerDetailsDAOImpl implements OwnerDetailsDAO {

	@Override
	public Integer insertDetails(OwnerDetailsEO ownerDetailsEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		Integer returnedPK = (Integer)sessionRef.save(ownerDetailsEORef);
		sessionRef.getTransaction().commit();
		sessionRef.close();		
		return returnedPK;
	}

	@Override
	public void updateDetails(OwnerDetailsEO ownerDetailsEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		OwnerDetailsEO ownerDetailsEOToBeUpdated = (OwnerDetailsEO)sessionRef.get(OwnerDetailsEO.class, ownerDetailsEORef.getOwnerId());
		ownerDetailsEOToBeUpdated.setAddProofName(ownerDetailsEORef.getAddProofName());
		ownerDetailsEOToBeUpdated.setDateofbirth(ownerDetailsEORef.getDateofbirth());
		ownerDetailsEOToBeUpdated.setFname(ownerDetailsEORef.getFname());
		ownerDetailsEOToBeUpdated.setGender(ownerDetailsEORef.getGender());
		ownerDetailsEOToBeUpdated.setLandlineNo(ownerDetailsEORef.getLandlineNo());
		ownerDetailsEOToBeUpdated.setLname(ownerDetailsEORef.getLname());
		ownerDetailsEOToBeUpdated.setMobileNo(ownerDetailsEORef.getMobileNo());
		ownerDetailsEOToBeUpdated.setOccupation(ownerDetailsEORef.getOccupation());
		ownerDetailsEOToBeUpdated.setTempAddr(ownerDetailsEORef.getTempAddr());
		ownerDetailsEOToBeUpdated.setPancardNo(ownerDetailsEORef.getPancardNo());
		ownerDetailsEOToBeUpdated.setPermAddr(ownerDetailsEORef.getPermAddr());
		ownerDetailsEOToBeUpdated.setPincode(ownerDetailsEORef.getPincode());
		sessionRef.update(ownerDetailsEOToBeUpdated);
		sessionRef.getTransaction().commit();
		sessionRef.close();

	}

	@Override
	public void deleteDetails(Integer ownerID) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		OwnerDetailsEO ownerDetailsEO = (OwnerDetailsEO)sessionRef.get(OwnerDetailsEO.class,ownerID);
		sessionRef.delete(ownerDetailsEO);
		sessionRef.getTransaction().commit();
		sessionRef.close();

	}

	@Override
	public OwnerDetailsEO findByOwnerID(Integer ownerID) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		OwnerDetailsEO ownerDetailsEO = (OwnerDetailsEO)sessionRef.get(OwnerDetailsEO.class, ownerID);
		sessionRef.close();
		return ownerDetailsEO;
	}

	@Override
	public List<OwnerDetailsEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
