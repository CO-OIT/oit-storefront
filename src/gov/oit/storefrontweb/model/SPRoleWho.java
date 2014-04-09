package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "SPRoleWho") 
public class SPRoleWho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spRoleWhoKey;
	private Employee employee;
	//private OitService oitService;
	private SPRoleClassification spRoleClassification;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
//	public OitService getOitService() {
//		return oitService;
//	}
//	public void setOitService(OitService oitService) {
//		this.oitService = oitService;
//	}
	public SPRoleClassification getSpRoleClassification() {
		return spRoleClassification;
	}
	public void setSpRoleClassification(SPRoleClassification spRoleClassification) {
		this.spRoleClassification = spRoleClassification;
	}
}
