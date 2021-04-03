package training.oracle.business.impl;

import java.util.List;

import training.oracle.business.RTOOperations;
import training.oracle.tms.dao.OffenceDAO;
import training.oracle.tms.entities.OffenceEO;

public class RTOOperationsImpl implements RTOOperations {
	
	private OffenceDAO offenceDaoRef;

	public OffenceDAO getOffenceDaoRef() {
		return offenceDaoRef;
	}

	public void setOffenceDaoRef(OffenceDAO offenceDaoRef) {
		this.offenceDaoRef = offenceDaoRef;
	}

	@Override
	public Integer addOffence(OffenceEO offenceEO) {
		return offenceDaoRef.insertOffence(offenceEO);
	}

	@Override
	public List<OffenceEO> listAllOffences() {
		return offenceDaoRef.findAll();
	}

}
