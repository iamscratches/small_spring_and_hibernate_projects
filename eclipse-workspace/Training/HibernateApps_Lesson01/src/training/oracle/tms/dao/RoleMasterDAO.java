package training.oracle.tms.dao;

import java.util.List;

import training.oracle.tms.entities.RoleMasterEO;

public interface RoleMasterDAO {
	
	public String insertRoleName(RoleMasterEO roleMasterEORef);
	
	public void updateRoleName(RoleMasterEO roleMasterEORef);
	
	public void deleteRoleName(String roleName);
	
	public RoleMasterEO findByRoleName(String roleName);
	
	public List<RoleMasterEO> findAll(); 

}
