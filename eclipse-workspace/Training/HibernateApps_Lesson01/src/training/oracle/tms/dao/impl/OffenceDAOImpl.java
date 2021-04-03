package training.oracle.tms.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;

import training.oracle.tms.criterion.SearchCriteria;
import training.oracle.tms.dao.OffenceDAO;
import training.oracle.tms.entities.OffenceEO;
import training.oracle.tms.util.HibernateUtil;

public class OffenceDAOImpl implements OffenceDAO {

	@Override
	public Integer insertOffence(OffenceEO offenceEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		Integer returnedPK = (Integer)sessionRef.save(offenceEORef);
		sessionRef.getTransaction().commit();
		sessionRef.close();
		return returnedPK;
	}

	@Override
	public void updateOffence(OffenceEO offenceEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		OffenceEO offenceEOToBeUpdated = (OffenceEO)sessionRef.get(OffenceEO.class, offenceEORef.getOffenceID());
		offenceEOToBeUpdated.setOffenceType(offenceEORef.getOffenceType());
		offenceEOToBeUpdated.setPenalty(offenceEORef.getPenalty());
		offenceEOToBeUpdated.setVehicleType(offenceEORef.getVehicleType());
		sessionRef.update(offenceEOToBeUpdated);
		sessionRef.getTransaction().commit();
		sessionRef.close();
	}

	@Override
	public void deleteOffence(Integer offenceID) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		OffenceEO offenceEOToBeDeleted =(OffenceEO)sessionRef.get(OffenceEO.class, offenceID);
		sessionRef.delete(offenceEOToBeDeleted);
		sessionRef.getTransaction().commit();
		sessionRef.close();
	}

	@Override
	public OffenceEO findByPrimaryKey(Integer offenceID) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
	 	OffenceEO returnedOffenceEO = (OffenceEO)sessionRef.get(OffenceEO.class, offenceID);
	 	sessionRef.close();
	 	return returnedOffenceEO;
	}

	@Override
	public List<OffenceEO> findAll() {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		String findAllHQL = "SELECT o FROM OffenceEO o";
		Query queryRef = sessionRef.createQuery(findAllHQL);
		List<OffenceEO> returnedOffenceList = queryRef.list();
		sessionRef.close();
		return returnedOffenceList;
	}
	
	@Override
	public List<OffenceEO> findAllOffencesBasedOnPenalty(Float givenPenalty){
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
//		String findAllOffencesBasedOnPenaltyHQL = "SELECT o FROM OffenceEO o WHERE o.penalty >= :userProvidedPenalty";
		//Externalizing the Queries
		Query queryRef = sessionRef.getNamedQuery("training.oracle.tms.entities.OffenceEO.findAllOffencesByPenalty");
		
//		Query queryRef = sessionRef.createQuery(findAllOffencesBasedOnPenaltyHQL);
		queryRef.setParameter("userProvidedPenalty", givenPenalty);
		List<OffenceEO> returnedOffenceList = queryRef.list();
		sessionRef.close();
		return returnedOffenceList;
	}

	@Override
	public List<OffenceEO> findAllBasedOnCriteria(List<SearchCriteria> searchConditions) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		Criteria searchCriteria = sessionRef.createCriteria(OffenceEO.class);
		return null;
	}

	@Override
	public List<OffenceEO> findAllBasedOnPrgCriteria() {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		List<OffenceEO> resultOffenceList = sessionRef.createCriteria(OffenceEO.class)
				.add(Restrictions.gt("penalty", new Float(1000.0f)))
				.add(Restrictions.like("vehicleType", "All Vehicles"))
				.addOrder(Order.asc("penalty"))
				.list();
		sessionRef.close();
		return resultOffenceList;
	}
	
	

}
