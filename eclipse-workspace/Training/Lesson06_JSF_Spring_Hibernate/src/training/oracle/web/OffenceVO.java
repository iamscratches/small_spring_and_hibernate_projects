package training.oracle.web;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import training.oracle.business.RTOOperations;
import training.oracle.tms.entities.OffenceEO;

public class OffenceVO {

	private Integer offenceID;

	private String offenceType;

	private Float penalty;

	private String vehType;

	private RTOOperations rto_OperRef;

	public RTOOperations getRto_OperRef() {
		return rto_OperRef;
	}

	public void setRto_OperRef(RTOOperations rto_OperRef) {
		this.rto_OperRef = rto_OperRef;
	}
	public OffenceVO() {

	}

	public OffenceVO(Integer offenceID, String offenceType, Float penalty, String vehType) {
		super();
		this.offenceID = offenceID;
		this.offenceType = offenceType;
		this.penalty = penalty;
		this.vehType = vehType;
	}

	public Integer getOffenceID() {
		return offenceID;
	}

	public void setOffenceID(Integer offenceID) {
		this.offenceID = offenceID;
	}

	public String getOffenceType() {
		return offenceType;
	}

	public void setOffenceType(String offenceType) {
		this.offenceType = offenceType;
	}

	public Float getPenalty() {
		return penalty;
	}

	public void setPenalty(Float penalty) {
		this.penalty = penalty;
	}
	public String getVehType() {
		return vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public String navigate()
	{
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ELContext elContext = facesContext.getELContext();
		ExpressionFactory expressionFactory =  facesContext.getApplication().getExpressionFactory();
		ValueExpression exp =  expressionFactory.createValueExpression(elContext,"#{offenceVORef}", OffenceVO.class);
		OffenceVO offVORef = (OffenceVO)exp.getValue(elContext); 
		
		
		OffenceEO actualData = new OffenceEO();
		actualData.setOffenceID(offVORef.getOffenceID());
		actualData.setOffenceType(offVORef.getOffenceType());
		actualData.setPenalty(offVORef.getPenalty());
		actualData.setVehicleType(offVORef.getVehType());
		
		int result = rto_OperRef.addOffence(actualData);
		String resultPage;
		if(result > 0)
		{
			resultPage = "success";
		}
		else
		{
			resultPage = "failure";
		}
		return resultPage;
	}

	@Override
	public String toString() {
		return "OffenceEO [offenceID=" + offenceID + ", offencyType=" + offenceType + ", penalty=" + penalty
				+ ", vehType=" + vehType + "]";
	}

}

