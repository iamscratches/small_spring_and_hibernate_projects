package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TM_USERMASTER database table.
 * 
 */
@Entity
@Table(name="TM_USERMASTER")
@NamedQuery(name="UsermasterEO.findAll", query="SELECT u FROM UsermasterEO u")
public class UsermasterEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	//bi-directional many-to-one association to OffenceDetailsEO
	@OneToMany(mappedBy="tmUsermaster")
	private List<OffenceDetailsEO> tmOffenceDetails;

	//bi-directional many-to-one association to RolemasterEO
	@ManyToOne
	@JoinColumn(name="ROLENAME")
	private RoleMasterEO tmRolemaster;

	public UsermasterEO() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<OffenceDetailsEO> getTmOffenceDetails() {
		return this.tmOffenceDetails;
	}

	public void setTmOffenceDetails(List<OffenceDetailsEO> tmOffenceDetails) {
		this.tmOffenceDetails = tmOffenceDetails;
	}

	public OffenceDetailsEO addTmOffenceDetail(OffenceDetailsEO tmOffenceDetail) {
		getTmOffenceDetails().add(tmOffenceDetail);
		tmOffenceDetail.setTmUsermaster(this);

		return tmOffenceDetail;
	}

	public OffenceDetailsEO removeTmOffenceDetail(OffenceDetailsEO tmOffenceDetail) {
		getTmOffenceDetails().remove(tmOffenceDetail);
		tmOffenceDetail.setTmUsermaster(null);

		return tmOffenceDetail;
	}

	public RoleMasterEO getTmRolemaster() {
		return this.tmRolemaster;
	}

	public void setTmRolemaster(RoleMasterEO tmRolemaster) {
		this.tmRolemaster = tmRolemaster;
	}

}