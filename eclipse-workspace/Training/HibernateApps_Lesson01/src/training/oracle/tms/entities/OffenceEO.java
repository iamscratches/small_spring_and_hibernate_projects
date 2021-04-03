package training.oracle.tms.entities;

public class OffenceEO {
	private Integer offenceID;
	
	private String offenceType;
	
	private Float penalty;
	
	private String vehicleType;

	public OffenceEO() {
		
	}
	
	public OffenceEO(Integer offenceID, String offenceType, Float penalty, String vehicleType) {
		super();
		this.offenceID = offenceID;
		this.offenceType = offenceType;
		this.penalty = penalty;
		this.vehicleType = vehicleType;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "OffenceEO [offenceID=" + offenceID + ", offenceType=" + offenceType + ", penalty=" + penalty
				+ ", vehicleType=" + vehicleType + "]";
	}
	
	

}
