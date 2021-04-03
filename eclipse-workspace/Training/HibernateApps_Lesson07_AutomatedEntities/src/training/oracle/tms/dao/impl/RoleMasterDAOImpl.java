package training.oracle.tms.dao.impl;

import java.util.List;

import org.hibernate.Session;

import training.oracle.tms.dao.RoleMasterDAO;
import training.oracle.tms.entities.OffenceEO;
import training.oracle.tms.entities.RoleMasterEO;
import training.oracle.tms.util.HibernateUtil;

public class RoleMasterDAOImpl implements RoleMasterDAO {

	@Override
	public String insertRoleName(RoleMasterEO roleMasterEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		String returnedPK = (String)sessionRef.save(roleMasterEORef);
		sessionRef.getTransaction().commit();
		sessionRef.close();
		return returnedPK;
	}

	@Override
	public void updateRoleName(RoleMasterEO roleMasterEORef) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		RoleMasterEO roleMasterEOToBeUpdated = (RoleMasterEO)sessionRef.get(RoleMasterEO.class, roleMasterEORef.getRolename());
		roleMasterEOToBeUpdated.setRolename(roleMasterEORef.getRolename());
		roleMasterEOToBeUpdated.setRoleDesc(roleMasterEORef.getRoleDesc());
		sessionRef.update(roleMasterEOToBeUpdated);
		sessionRef.getTransaction().commit();
		sessionRef.close();

	}

	@Override
	public void deleteRoleName(String roleName) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		sessionRef.beginTransaction();
		RoleMasterEO roleMasterEO =(RoleMasterEO)sessionRef.get(RoleMasterEO.class, roleName);
		sessionRef.delete(roleMasterEO);
		sessionRef.getTransaction().commit();
		sessionRef.close();
	}

	@Override
	public RoleMasterEO findByRoleName(String roleName) {
		Session sessionRef = HibernateUtil.getSessionFactory().openSession();
		RoleMasterEO returnedRoleMasterEO = (RoleMasterEO)sessionRef.get(RoleMasterEO.class, roleName);
	 	sessionRef.close();
	 	return returnedRoleMasterEO;
	}

	@Override
	public List<RoleMasterEO> findAll() {
	return null;
	}

}
