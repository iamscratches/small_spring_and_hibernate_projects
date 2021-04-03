package training.oracle.tms.dao;
import java.util.List;

import training.oracle.tms.entities.OwnerDetailsEO;

public interface OwnerDetailsDAO {
public Integer insertDetails(OwnerDetailsEO ownerDetailsEORef);
	
	public void updateDetails(OwnerDetailsEO ownerDetailsEORef);
	
	public void deleteDetails(Integer ownerID);
	
	public OwnerDetailsEO findByOwnerID(Integer ownerID);
	
	public List<OwnerDetailsEO> findAll(); 
}
