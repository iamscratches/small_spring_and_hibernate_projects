package training.oracle.tms.test;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import training.oracle.tms.dao.VehicleDetailsDAO;
import training.oracle.tms.dao.impl.VehicleDetailsDAOImpl;
import training.oracle.tms.entities.VehicleDetailsEO;

public class VehicleDetailsDAOTest {
	
	private VehicleDetailsDAO vehicleDetailsDAORef = new VehicleDetailsDAOImpl();
	
	@Test
	public void testInsertDetails() {
		Date d = java.sql.Date.valueOf("2021-11-15");
		VehicleDetailsEO vehicleDetailsEORef = new VehicleDetailsEO();
		vehicleDetailsEORef.setCubicCapacity(100);
		vehicleDetailsEORef.setdOM(d);
		vehicleDetailsEORef.setEngineNo("EB20Kd208");
		vehicleDetailsEORef.setFuelUsed("Gasoline");
		vehicleDetailsEORef.setManufacturerName("Tesla");
		vehicleDetailsEORef.setModelNo("Smart20");
		vehicleDetailsEORef.setNoOfCylinders(5);
		vehicleDetailsEORef.setVehicleColor("Blue");
		vehicleDetailsEORef.setVehicleID(43210);
		vehicleDetailsEORef.setVehicleName("Nasta");
		vehicleDetailsEORef.setVehicleType("Car");
		
		Integer retVehicleID = vehicleDetailsDAORef.insertDetails(vehicleDetailsEORef);
		Assert.assertEquals(new Integer(43210), retVehicleID);
	}
	
	@Test
	public void updateVehicleDetails()
	{
		Date d = java.sql.Date.valueOf("2017-11-15");
		VehicleDetailsEO vehicleDetailsEORef = new VehicleDetailsEO();
		vehicleDetailsEORef.setCubicCapacity(100);
		vehicleDetailsEORef.setdOM(d);
		vehicleDetailsEORef.setEngineNo("EB2K0");
		vehicleDetailsEORef.setFuelUsed("Electric");
		vehicleDetailsEORef.setManufacturerName("Tesla");
		vehicleDetailsEORef.setModelNo("Smart2020");
		vehicleDetailsEORef.setNoOfCylinders(5);
		vehicleDetailsEORef.setVehicleColor("Red");
		vehicleDetailsEORef.setVehicleID(1234);
		vehicleDetailsEORef.setVehicleName("Basta");
		vehicleDetailsEORef.setVehicleType("Car");
		vehicleDetailsDAORef.updateDetails(vehicleDetailsEORef);
	}
	
	@Test
	public void fetchVehicleDetails()
	{
		VehicleDetailsEO returnedVehicleDetailsEORef = 
				vehicleDetailsDAORef.findByVehicleID(12345);
		System.out.println(returnedVehicleDetailsEORef);
	}
	
	@Test
	public void deleteVehicleDetails()
	{
		vehicleDetailsDAORef.deleteDetails(12345);
		
	}
}
