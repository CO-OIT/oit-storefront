package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "Employee") 
public class Employee {
	
	@Id	
	private int eid;
	
	@OneToOne(mappedBy="agency")
	private Agency agency;
	
	private String unit;
	private String employeeName; //Replace with Google record
	private String email;
	private String phone1;
	private String phone2;
    private String positionNum;
    private boolean active;
    
    public Employee() {}
    public Employee(int in_eid) { eid = in_eid; }
	    
    public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPositionNum() {
		return positionNum;
	}
	public void setPositionNum(String positionNum) {
		this.positionNum = positionNum;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}
