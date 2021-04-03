package training.oracle.tms.test;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import training.oracle.tms.dao.OwnerDetailsDAO;
import training.oracle.tms.dao.impl.OwnerDetailsDAOImpl;
import training.oracle.tms.entities.OwnerDetailsEO;

public class OwnerDetailsDAOTest {
	private OwnerDetailsDAO ownerDetailsDAORef = new OwnerDetailsDAOImpl();
	
	@Test
	public void testInsertDetails() {
		Date d = java.sql.Date.valueOf("2021-11-15");
		OwnerDetailsEO ownerDetailsEORef = new OwnerDetailsEO();
		ownerDetailsEORef.setAddProofName("Adhaar");
		ownerDetailsEORef.setdOB(d);
		ownerDetailsEORef.setfName("suvnkr");
		ownerDetailsEORef.setlName("Bhatt");
		ownerDetailsEORef.setGender('M');
		ownerDetailsEORef.setLandlineNo("+918617463248");
		ownerDetailsEORef.setMobileNo("8167881888");
		ownerDetailsEORef.setOccupation("Software Engineer");
		ownerDetailsEORef.setOwnerID(1234);
		ownerDetailsEORef.setPanCardNo("Nasta");
		ownerDetailsEORef.setPermAddress("Car");
		ownerDetailsEORef.setTempAddress("Car");
		ownerDetailsEORef.setPincode(700102);
		Integer retOwnerID = ownerDetailsDAORef.insertDetails(ownerDetailsEORef);
		Assert.assertEquals(new Integer(1234), retOwnerID);
	}
	
	@Test
	public void updateOwnerDetails()
	{
		Date d = java.sql.Date.valueOf("2017-11-15");
		OwnerDetailsEO ownerDetailsEORef = new OwnerDetailsEO();
		ownerDetailsEORef.setAddProofName("Adhaar card");
		ownerDetailsEORef.setdOB(d);
		ownerDetailsEORef.setfName("Subhankar");
		ownerDetailsEORef.setlName("Bhattacharyya");
		ownerDetailsEORef.setGender('M');
		ownerDetailsEORef.setLandlineNo("+918617463248");
		ownerDetailsEORef.setMobileNo("8167881888");
		ownerDetailsEORef.setOccupation("Software Engineer");
		ownerDetailsEORef.setPermAddress("Car");
		ownerDetailsEORef.setPanCardNo("Nasta");
		ownerDetailsEORef.setOwnerID(1234);
		ownerDetailsEORef.setPincode(700102);
		ownerDetailsDAORef.updateDetails(ownerDetailsEORef);
	}
	
	@Test
	public void fetchOwnerDetails()
	{
		OwnerDetailsEO returnedOwnerDetailsEORef = 
				ownerDetailsDAORef.findByOwnerID(1234);
		System.out.println(returnedOwnerDetailsEORef);
	}
	
	@Test
	public void deleteOwnerDetails()
	{
		ownerDetailsDAORef.deleteDetails(1234);
		
	}
}
