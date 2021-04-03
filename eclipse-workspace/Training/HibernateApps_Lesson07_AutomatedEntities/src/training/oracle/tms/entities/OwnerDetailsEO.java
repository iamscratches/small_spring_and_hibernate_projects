package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TM_OWNERDETAILS database table.
 * 
 */
@Entity
@Table(name="TM_OWNERDETAILS")
@NamedQuery(name="OwnerdetailsEO.findAll", query="SELECT o FROM OwnerdetailsEO o")
public class OwnerDetailsEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OWNER_ID")
	private long ownerId;

	@Column(name="ADD_PROOF_NAME")
	private String addProofName;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String fname;

	private Character gender;

	@Column(name="LANDLINE_NO")
	private String landlineNo;

	private String lname;

	@Column(name="MOBILE_NO")
	private String mobileNo;

	private String occupation;

	@Column(name="PANCARD_NO")
	private String pancardNo;

	@Column(name="PERM_ADDR")
	private String permAddr;

	private Integer pincode;

	@Column(name="TEMP_ADDR")
	private String tempAddr;

	//bi-directional many-to-one association to RegistrationEO
	@OneToMany(mappedBy="tmOwnerdetail")
	private List<RegistrationEO> tmRegdetails;

	public OwnerDetailsEO() {
	}

	public long getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getAddProofName() {
		return this.addProofName;
	}

	public void setAddProofName(String addProofName) {
		this.addProofName = addProofName;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Character getGender() {
		return this.gender;
	}

	public void setGender(char c) {
		this.gender = c;
	}

	public String getLandlineNo() {
		return this.landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPancardNo() {
		return this.pancardNo;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

	public String getPermAddr() {
		return this.permAddr;
	}

	public void setPermAddr(String permAddr) {
		this.permAddr = permAddr;
	}

	public Integer getPincode() {
		return this.pincode;
	}

	public void setPincode(int i) {
		this.pincode = i;
	}

	public String getTempAddr() {
		return this.tempAddr;
	}

	public void setTempAddr(String tempAddr) {
		this.tempAddr = tempAddr;
	}

	public List<RegistrationEO> getTmRegdetails() {
		return this.tmRegdetails;
	}

	public void setTmRegdetails(List<RegistrationEO> tmRegdetails) {
		this.tmRegdetails = tmRegdetails;
	}

	public RegistrationEO addTmRegdetail(RegistrationEO tmRegdetail) {
		getTmRegdetails().add(tmRegdetail);
		tmRegdetail.setTmOwnerdetail(this);

		return tmRegdetail;
	}

	public RegistrationEO removeTmRegdetail(RegistrationEO tmRegdetail) {
		getTmRegdetails().remove(tmRegdetail);
		tmRegdetail.setTmOwnerdetail(null);

		return tmRegdetail;
	}

}