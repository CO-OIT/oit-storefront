package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "SPRoleClassification") 
public class SPRoleClassification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spRoleClassificationKey;
	private SPRoleArea spRoleArea;
	private String roleClassificationDescription;
	public SPRoleArea getSpRoleArea() {
		return spRoleArea;
	}
	public void setSpRoleArea(SPRoleArea spRoleArea) {
		this.spRoleArea = spRoleArea;
	}
	public String getRoleClassificationDescription() {
		return roleClassificationDescription;
	}
	public void setRoleClassificationDescription(
			String roleClassificationDescription) {
		this.roleClassificationDescription = roleClassificationDescription;
	}

}
