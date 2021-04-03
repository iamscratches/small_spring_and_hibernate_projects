package training.oracle.tms.test;

import org.junit.Assert;
import org.junit.Test;
import training.oracle.tms.dao.RoleMasterDAO;
import training.oracle.tms.dao.impl.RoleMasterDAOImpl;
import training.oracle.tms.entities.RoleMasterEO;

public class RoleMasterDAOTest {
	private RoleMasterDAO roleMasterDAORef = new RoleMasterDAOImpl();
	
	@Test
	public void testInsertOffence() {
		RoleMasterEO roleMasterEORef = new RoleMasterEO();
		roleMasterEORef.setRolename("Cop");
		roleMasterEORef.setRoleDesc("Adding Offence and offence details along with vehicle and owner ID");
		
		String retRoleMasterName = roleMasterDAORef.insertRoleName(roleMasterEORef);
		Assert.assertEquals(new String("Admin"), retRoleMasterName);
	}
	@Test
	public void UpdateRoleNameTest()
	{
		RoleMasterEO roleMasterEORef = new RoleMasterEO();
		roleMasterEORef.setRolename("Admin");
		roleMasterEORef.setRoleDesc("Creation and maintainance of roles");
		roleMasterDAORef.updateRoleName(roleMasterEORef);
	}
	
	@Test
	public void FetchOffenceTest()
	{
		RoleMasterEO returnedRoleMasterEORef = 
				roleMasterDAORef.findByRoleName("Admin");
		System.out.println(returnedRoleMasterEORef);
	}
	
	@Test
	public void DeleteOffenceTest()
	{
		roleMasterDAORef.deleteRoleName("Admin");
		
	}
}
