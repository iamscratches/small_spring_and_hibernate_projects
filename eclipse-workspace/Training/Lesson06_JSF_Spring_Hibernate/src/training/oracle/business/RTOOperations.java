package training.oracle.business;

import java.util.List;

import training.oracle.tms.entities.OffenceEO;

public interface RTOOperations {
	
	public Integer addOffence(OffenceEO offenceEO);
	
	public List<OffenceEO> listAllOffences();
	
	

}
