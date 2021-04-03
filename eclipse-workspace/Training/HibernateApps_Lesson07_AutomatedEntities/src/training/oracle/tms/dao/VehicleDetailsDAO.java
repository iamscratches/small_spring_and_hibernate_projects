package training.oracle.tms.dao;

import java.util.List;

import training.oracle.tms.entities.VehicleDetailsEO;

public interface VehicleDetailsDAO {
	public Integer insertDetails(VehicleDetailsEO vehicleDetailsEORef);
	
	public void updateDetails(VehicleDetailsEO vehicleDetailsEORef);
	
	public void deleteDetails(Integer vehicleID);
	
	public VehicleDetailsEO findByVehicleID(Integer vehicleID);
	
	public List<VehicleDetailsEO> findAll(); 
}
