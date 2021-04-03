package training.oracle.tms.entities;

import java.sql.Date;

public class OwnerDetailsEO {

	private Integer ownerID;
	private String fName;
	private String lName;
	private String landlineNo;
	private String mobileNo;
	private Character gender;
	private String tempAddress;
	private String permAddress;
	private Date dOB;//date of birth
	private Integer pincode;
	private String occupation;
	private String panCardNo;
	private String addProofName;
	
	public OwnerDetailsEO(){
		
	}

	public OwnerDetailsEO(Integer ownerID, String fName, String lName, String landlineNo, String mobileNo,
			Character gender, String tempAddress, String permAddress, Date dOB, Integer pincode, String occupation,
			String panCardNo, String addProofName) {
		super();
		this.ownerID = ownerID;
		this.fName = fName;
		this.lName = lName;
		this.landlineNo = landlineNo;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.tempAddress = tempAddress;
		this.permAddress = permAddress;
		this.dOB = dOB;
		this.pincode = pincode;
		this.occupation = occupation;
		this.panCardNo = panCardNo;
		this.addProofName = addProofName;
	}

	public Integer getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Integer ownerID) {
		this.ownerID = ownerID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public String getAddProofName() {
		return addProofName;
	}

	public void setAddProofName(String addProofName) {
		this.addProofName = addProofName;
	}

	@Override
	public String toString() {
		return "OwnerDetailsEO [ownerID=" + ownerID + ", fName=" + fName + ", lName=" + lName + ", landlineNo="
				+ landlineNo + ", mobileNo=" + mobileNo + ", gender=" + gender + ", tempAddress=" + tempAddress
				+ ", permAddress=" + permAddress + ", dOB=" + dOB + ", pincode=" + pincode + ", occupation="
				+ occupation + ", panCardNo=" + panCardNo + ", addProofName=" + addProofName + "]";
	}
	
}
