package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TM_OFFENCE_DETAILS database table.
 * 
 */
@Entity
@Table(name="TM_OFFENCE_DETAILS")
@NamedQuery(name="OffenceDetailsEO.findAll", query="SELECT o FROM OffenceDetailsEO o")
public class OffenceDetailsEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OFFENCE_DETAIL_ID")
	private long offenceDetailId;

	@Lob
	private byte[] image;

	@Column(name="OFFENCE_STATUS")
	private String offenceStatus;

	private String place;

	@Temporal(TemporalType.DATE)
	@Column(name="\"TIME\"")
	private Date time;

	//bi-directional many-to-one association to OffenceEO
	@ManyToOne
	@JoinColumn(name="OFFENCE_ID")
	private OffenceEO tmOffence;

	//bi-directional many-to-one association to RegistrationEO
	@ManyToOne
	@JoinColumn(name="VEH_NO")
	private RegistrationEO tmRegdetail;

	//bi-directional many-to-one association to UsermasterEO
	@ManyToOne
	@JoinColumn(name="REPORTED_BY")
	private UsermasterEO tmUsermaster;

	public OffenceDetailsEO() {
	}

	public long getOffenceDetailId() {
		return this.offenceDetailId;
	}

	public void setOffenceDetailId(long offenceDetailId) {
		this.offenceDetailId = offenceDetailId;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getOffenceStatus() {
		return this.offenceStatus;
	}

	public void setOffenceStatus(String offenceStatus) {
		this.offenceStatus = offenceStatus;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public OffenceEO getTmOffence() {
		return this.tmOffence;
	}

	public void setTmOffence(OffenceEO tmOffence) {
		this.tmOffence = tmOffence;
	}

	public RegistrationEO getTmRegdetail() {
		return this.tmRegdetail;
	}

	public void setTmRegdetail(RegistrationEO tmRegdetail) {
		this.tmRegdetail = tmRegdetail;
	}

	public UsermasterEO getTmUsermaster() {
		return this.tmUsermaster;
	}

	public void setTmUsermaster(UsermasterEO tmUsermaster) {
		this.tmUsermaster = tmUsermaster;
	}

}