package training.oracle.tms.entities;

public class RoleMasterEO {
	private String roleName;
	private String roleDesc;
	
	public RoleMasterEO() {
		
	}

	public RoleMasterEO(String roleName, String roleDesc) {
		super();
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "RoleMasterEO [roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}
	

}
