package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TM_VEHICLEDETAILS database table.
 * 
 */
@Entity
@Table(name="TM_VEHICLEDETAILS")
@NamedQuery(name="VehicledetailEO.findAll", query="SELECT v FROM VehicledetailEO v")
public class VehicledetailEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEH_ID")
	private long vehId;

	@Column(name="CUBIC_CAPACITY")
	private BigDecimal cubicCapacity;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_MANUFACTURE")
	private Date dateOfManufacture;

	@Column(name="ENGINE_NO")
	private String engineNo;

	@Column(name="FUEL_USED")
	private String fuelUsed;

	@Column(name="MANUFACTURER_NAME")
	private String manufacturerName;

	@Column(name="MODEL_NO")
	private String modelNo;

	@Column(name="NO_OF_CYLINDERS")
	private BigDecimal noOfCylinders;

	@Column(name="VEH_COLOR")
	private String vehColor;

	@Column(name="VEH_NAME")
	private String vehName;

	@Column(name="VEH_TYPE")
	private String vehType;

	public VehicledetailEO() {
	}

	public long getVehId() {
		return this.vehId;
	}

	public void setVehId(long vehId) {
		this.vehId = vehId;
	}

	public BigDecimal getCubicCapacity() {
		return this.cubicCapacity;
	}

	public void setCubicCapacity(BigDecimal cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public Date getDateOfManufacture() {
		return this.dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public String getEngineNo() {
		return this.engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getFuelUsed() {
		return this.fuelUsed;
	}

	public void setFuelUsed(String fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getModelNo() {
		return this.modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public BigDecimal getNoOfCylinders() {
		return this.noOfCylinders;
	}

	public void setNoOfCylinders(BigDecimal noOfCylinders) {
		this.noOfCylinders = noOfCylinders;
	}

	public String getVehColor() {
		return this.vehColor;
	}

	public void setVehColor(String vehColor) {
		this.vehColor = vehColor;
	}

	public String getVehName() {
		return this.vehName;
	}

	public void setVehName(String vehName) {
		this.vehName = vehName;
	}

	public String getVehType() {
		return this.vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

}