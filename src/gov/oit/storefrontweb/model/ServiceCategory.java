package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "ServiceCategory") 
public class ServiceCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceCategoryKey;
	private String categoryDescription;
    private ServicePortfolio servicePortfolio;
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public ServicePortfolio getServicePortfolio() {
		return servicePortfolio;
	}
	public void setServicePortfolio(ServicePortfolio servicePortfolio) {
		this.servicePortfolio = servicePortfolio;
	}
}
