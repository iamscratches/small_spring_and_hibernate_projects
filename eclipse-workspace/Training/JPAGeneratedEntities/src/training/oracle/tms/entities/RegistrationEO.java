package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TM_REGDETAILS database table.
 * 
 */
@Entity
@Table(name="TM_REGDETAILS")
@NamedQuery(name="RegistrationEO.findAll", query="SELECT r FROM RegistrationEO r")
public class RegistrationEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEH_NO")
	private String vehNo;

	@Column(name="APP_NO")
	private BigDecimal appNo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_PURCHASE")
	private Date dateOfPurchase;

	@Column(name="DISTRUBUTER_NAME")
	private String distrubuterName;

	@Column(name="VEH_ID")
	private BigDecimal vehId;

	//bi-directional many-to-one association to OffenceDetailsEO
	@OneToMany(mappedBy="tmRegdetail")
	private List<OffenceDetailsEO> tmOffenceDetails;

	//bi-directional many-to-one association to OwnerdetailsEO
	@ManyToOne
	@JoinColumn(name="OWNER_ID")
	private OwnerdetailsEO tmOwnerdetail;

	public RegistrationEO() {
	}

	public String getVehNo() {
		return this.vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public BigDecimal getAppNo() {
		return this.appNo;
	}

	public void setAppNo(BigDecimal appNo) {
		this.appNo = appNo;
	}

	public Date getDateOfPurchase() {
		return this.dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getDistrubuterName() {
		return this.distrubuterName;
	}

	public void setDistrubuterName(String distrubuterName) {
		this.distrubuterName = distrubuterName;
	}

	public BigDecimal getVehId() {
		return this.vehId;
	}

	public void setVehId(BigDecimal vehId) {
		this.vehId = vehId;
	}

	public List<OffenceDetailsEO> getTmOffenceDetails() {
		return this.tmOffenceDetails;
	}

	public void setTmOffenceDetails(List<OffenceDetailsEO> tmOffenceDetails) {
		this.tmOffenceDetails = tmOffenceDetails;
	}

	public OffenceDetailsEO addTmOffenceDetail(OffenceDetailsEO tmOffenceDetail) {
		getTmOffenceDetails().add(tmOffenceDetail);
		tmOffenceDetail.setTmRegdetail(this);

		return tmOffenceDetail;
	}

	public OffenceDetailsEO removeTmOffenceDetail(OffenceDetailsEO tmOffenceDetail) {
		getTmOffenceDetails().remove(tmOffenceDetail);
		tmOffenceDetail.setTmRegdetail(null);

		return tmOffenceDetail;
	}

	public OwnerdetailsEO getTmOwnerdetail() {
		return this.tmOwnerdetail;
	}

	public void setTmOwnerdetail(OwnerdetailsEO tmOwnerdetail) {
		this.tmOwnerdetail = tmOwnerdetail;
	}

}