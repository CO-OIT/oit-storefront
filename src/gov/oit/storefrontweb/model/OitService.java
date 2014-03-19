package gov.oit.storefrontweb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name = "OitService") 
public class OitService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oitServiceKey;

	private String serviceName;
	private String description;
	
	@ManyToOne()
	private Agency agency;
	
	private Date dateAddedToSP;
	private Date fundedThroughDate;
	private Boolean active;
	private List<SPKeyword> keywords;
	
	@OneToOne()
	private ServiceCategory serviceCategory;
    
	private List<String> serviceClassifications; //Replace with List<ServiceClassifications>
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public Date getDateAddedToSP() {
		return dateAddedToSP;
	}
	public void setDateAddedToSP(Date dateAddedToSP) {
		this.dateAddedToSP = dateAddedToSP;
	}
	public Date getFundedThroughDate() {
		return fundedThroughDate;
	}
	public void setFundedThroughDate(Date fundedThroughDate) {
		this.fundedThroughDate = fundedThroughDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<SPKeyword> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<SPKeyword> keywords) {
		this.keywords = keywords;
	}
	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public List<String> getServiceClassifications() {
		return serviceClassifications;
	}
	public void setServiceClassifications(List<String> serviceClassifications) {
		this.serviceClassifications = serviceClassifications;
	}
	
	public int commit()
	{
		return -1;
	}
	
}
