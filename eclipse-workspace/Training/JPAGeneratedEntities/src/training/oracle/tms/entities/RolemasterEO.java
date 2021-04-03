package training.oracle.tms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TM_ROLEMASTER database table.
 * 
 */
@Entity
@Table(name="TM_ROLEMASTER")
@NamedQuery(name="RolemasterEO.findAll", query="SELECT r FROM RolemasterEO r")
public class RolemasterEO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rolename;

	@Column(name="ROLE_DESC")
	private String roleDesc;

	//bi-directional many-to-one association to UsermasterEO
	@OneToMany(mappedBy="tmRolemaster")
	private List<UsermasterEO> tmUsermasters;

	public RolemasterEO() {
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<UsermasterEO> getTmUsermasters() {
		return this.tmUsermasters;
	}

	public void setTmUsermasters(List<UsermasterEO> tmUsermasters) {
		this.tmUsermasters = tmUsermasters;
	}

	public UsermasterEO addTmUsermaster(UsermasterEO tmUsermaster) {
		getTmUsermasters().add(tmUsermaster);
		tmUsermaster.setTmRolemaster(this);

		return tmUsermaster;
	}

	public UsermasterEO removeTmUsermaster(UsermasterEO tmUsermaster) {
		getTmUsermasters().remove(tmUsermaster);
		tmUsermaster.setTmRolemaster(null);

		return tmUsermaster;
	}

}