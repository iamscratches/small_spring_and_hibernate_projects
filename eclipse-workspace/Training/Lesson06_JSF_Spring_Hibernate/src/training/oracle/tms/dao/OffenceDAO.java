package training.oracle.tms.dao;

import java.util.List;
import java.util.Map;

import training.oracle.tms.criterion.SearchCriteria;
import training.oracle.tms.entities.OffenceEO;

public interface OffenceDAO {
	
	public Integer insertOffence(OffenceEO offenceEORef);
	
	public void updateOffence(OffenceEO offenceEORef);
	
	public void deleteOffence(Integer offenceID);
	
	public OffenceEO findByPrimaryKey(Integer offenceID);
	
	public List<OffenceEO> findAll();
	
	public List<OffenceEO> findAllOffencesBasedOnPenalty(Float givenPenalty);
	
	public List<OffenceEO> findAllBasedOnCriteria(List<SearchCriteria> searchConditions);
	
	public List<OffenceEO> findAllBasedOnPrgCriteria();

}
