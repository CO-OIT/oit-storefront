package gov.oit.storefrontweb.model;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "ServicePortfolio") 
public class ServicePortfolio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicePortfolioKey;
	
	private String portfolioDescription;
	private Date portfolioAddDate;
	private Boolean portfolioActive;
	public String getPortfolioDescription() {
		return portfolioDescription;
	}
	public void setPortfolioDescription(String portfolioDescription) {
		this.portfolioDescription = portfolioDescription;
	}
	public Date getPortfolioAddDate() {
		return portfolioAddDate;
	}
	public void setPortfolioAddDate(Date portfolioAddDate) {
		this.portfolioAddDate = portfolioAddDate;
	}
	public Boolean getPortfolioActive() {
		return portfolioActive;
	}
	public void setPortfolioActive(Boolean portfolioActive) {
		this.portfolioActive = portfolioActive;
	}
	
}
