package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "SPRoleArea") 
public class SPRoleArea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spRoleAreaKey;
	private String spRoleAreaDescription;
	public String getSpRoleAreaDescription() {
		return spRoleAreaDescription;
	}
	public void setSpRoleAreaDescription(String spRoleAreaDescription) {
		this.spRoleAreaDescription = spRoleAreaDescription;
	}

}
