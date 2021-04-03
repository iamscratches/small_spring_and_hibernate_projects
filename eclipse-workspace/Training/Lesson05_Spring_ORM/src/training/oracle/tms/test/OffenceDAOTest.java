package training.oracle.tms.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import training.oracle.tms.dao.OffenceDAO;
import training.oracle.tms.dao.impl.OffenceDAOImpl;
import training.oracle.tms.entities.OffenceEO;

public class OffenceDAOTest {
	
	private OffenceDAO offenceDAORef = new OffenceDAOImpl();
	
	@Test
	public void testInsertOffence() {
		OffenceEO offenceEORef = new OffenceEO();
		offenceEORef.setOffenceID(1003);
		offenceEORef.setOffenceType("Without breaks");
		offenceEORef.setPenalty(50000.0f);
		offenceEORef.setVehicleType("All vehicles");
		
		Integer retOffenceID = offenceDAORef.insertOffence(offenceEORef);
		Assert.assertEquals(new Integer(1003), retOffenceID);
	}
	@Test
	public void UpdateOffenceTest()
	{
		OffenceEO offenceEORef = new OffenceEO();
		offenceEORef.setOffenceID(1006);
		offenceEORef.setOffenceType("Without helmet");
		offenceEORef.setPenalty(5000.0f);
		offenceEORef.setVehicleType("All Vehicles");
		offenceDAORef.updateOffence(offenceEORef);
	}
	
	@Test
	public void FetchOffenceTest()
	{
		OffenceEO returnedOffenceEORef = 
				offenceDAORef.findByPrimaryKey(1004);
		System.out.println(returnedOffenceEORef);
	}
	
	@Test
	public void DeleteOffenceTest()
	{
		offenceDAORef.deleteOffence(1003);
		
	}
	
	@Test
	public void findAllTest() {
		List<OffenceEO> resultOffenceList = offenceDAORef.findAll();
		for (OffenceEO offenceEO : resultOffenceList) {
			System.out.println(offenceEO);
		}
	}
	
	@Test
	public void findBasedOnPenaltyTest() {
		List<OffenceEO> resultOffenceList = offenceDAORef.findAllOffencesBasedOnPenalty(2000.0f);
		for (OffenceEO offenceEO : resultOffenceList) {
			System.out.println(offenceEO);
		}
	}
	
	@Test
	public void findPrgCriteria(){
		List<OffenceEO> result = offenceDAORef.findAllBasedOnPrgCriteria();
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			OffenceEO offenceEO = (OffenceEO) iterator.next();
			System.out.println(offenceEO);
			
		}
	}

}
