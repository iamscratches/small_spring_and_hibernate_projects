package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;


/**
 * The persistent class for the TM_OFFENCE database table.
 * 
 */
@Entity
@Table(name="TM_OFFENCE")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="OffenceEO.findAll", query="SELECT o FROM OffenceEO o")
public class OffenceEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OFFENCE_ID")
	private long offenceId;

	@Column(name="OFFENCE_TYPE")
	private String offenceType;

	private float penalty;

	@Column(name="VEH_TYPE")
	private String vehType;

	//bi-directional many-to-one association to OffenceDetailsEO
	@OneToMany(mappedBy="tmOffence")
	private List<OffenceDetailsEO> tmOffenceDetails;

	public OffenceEO() {
	}

	public long getOffenceId() {
		return this.offenceId;
	}

	public void setOffenceId(long offenceId) {
		this.offenceId = offenceId;
	}

	public String getOffenceType() {
		return this.offenceType;
	}

	public void setOffenceType(String offenceType) {
		this.offenceType = offenceType;
	}

	public float getPenalty() {
		return this.penalty;
	}

	public void setPenalty(float f) {
		this.penalty = f;
	}

	public String getVehType() {
		return this.vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public List<OffenceDetailsEO> getTmOffenceDetails() {
		return this.tmOffenceDetails;
	}

	public void setTmOffenceDetails(List<OffenceDetailsEO> tmOffenceDetails) {
		this.tmOffenceDetails = tmOffenceDetails;
	}

	public OffenceDetailsEO addTmOffenceDetail(OffenceDetailsEO tmOffenceDetail) {
		getTmOffenceDetails().add(tmOffenceDetail);
		tmOffenceDetail.setTmOffence(this);

		return tmOffenceDetail;
	}

	public OffenceDetailsEO removeTmOffenceDetail(OffenceDetailsEO tmOffenceDetail) {
		getTmOffenceDetails().remove(tmOffenceDetail);
		tmOffenceDetail.setTmOffence(null);

		return tmOffenceDetail;
	}

}