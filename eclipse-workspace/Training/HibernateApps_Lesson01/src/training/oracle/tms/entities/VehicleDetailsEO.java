package training.oracle.tms.entities;

import java.sql.Date;

public class VehicleDetailsEO {
	private Integer vehicleID;
	private String vehicleType;
	private String engineNo;
	private String modelNo;
	private String vehicleName;
	private String vehicleColor;
	private String manufacturerName;
	private Date dOM;//date of manufacture
	private Integer noOfCylinders;
	private Integer cubicCapacity;
	private String fuelUsed;
	
	public VehicleDetailsEO() {
		
	}

	public VehicleDetailsEO(Integer vehicleID, String vehicleType, String engineNo, String modelNo, String vehicleName,
			String vehicleColor, String manufacturerName, Date dOM, Integer noOfCylinders, Integer cubicCapacity,
			String fuelUsed) {
		super();
		this.vehicleID = vehicleID;
		this.vehicleType = vehicleType;
		this.engineNo = engineNo;
		this.modelNo = modelNo;
		this.vehicleName = vehicleName;
		this.vehicleColor = vehicleColor;
		this.manufacturerName = manufacturerName;
		this.dOM = dOM;
		this.noOfCylinders = noOfCylinders;
		this.cubicCapacity = cubicCapacity;
		this.fuelUsed = fuelUsed;
	}

	public Integer getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(Integer vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Date getdOM() {
		return dOM;
	}

	public void setdOM(Date dOM) {
		this.dOM = dOM;
	}

	public Integer getNoOfCylinders() {
		return noOfCylinders;
	}

	public void setNoOfCylinders(Integer noOfCylinders) {
		this.noOfCylinders = noOfCylinders;
	}

	public Integer getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(Integer cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public String getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(String fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	@Override
	public String toString() {
		return "VehicleDetailsEO [vehicleID=" + vehicleID + ", vehicleType=" + vehicleType + ", engineNo=" + engineNo
				+ ", modelNo=" + modelNo + ", vehicleName=" + vehicleName + ", vehicleColor=" + vehicleColor
				+ ", manufacturerName=" + manufacturerName + ", dOM=" + dOM + ", noOfCylinders=" + noOfCylinders
				+ ", cubicCapacity=" + cubicCapacity + ", fuelUsed=" + fuelUsed + "]";
	}
	

}
