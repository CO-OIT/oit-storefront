package gov.oit.storefrontweb.model;

import gov.oit.storefrontweb.shared.EMF;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity(name = "OitService") 
public class OitService extends ActiveRecord  {

	@Id
	private Key key;

	private String oitServiceId;
	private String serviceName;
	private String description;
	
//	@ManyToOne()
//	private Agency agency;
	
	private Date dateAddedToSP;
	private Date fundedThroughDate;
	private Boolean active;
	//private List<SPKeyword> keywords;
	
//	@OneToOne()
//	private ServiceCategory serviceCategory;
    
	private List<String> serviceClassifications; //Replace with List<ServiceClassifications>
	
	public OitService(String oitServiceId) {
		this.oitServiceId = oitServiceId;
		this.setKey(oitServiceId);
	}
	
	
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
//	public Agency getAgency() {
//		return agency;
//	}
//	public void setAgency(Agency agency) {
//		this.agency = agency;
//	}
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
	
//	public List<SPKeyword> getKeywords() {
//		return keywords;
//	}
//	public void setKeywords(List<SPKeyword> keywords) {
//		this.keywords = keywords;
//	}
//	public ServiceCategory getServiceCategory() {
//		return serviceCategory;
//	}
//	public void setServiceCategory(ServiceCategory serviceCategory) {
//		this.serviceCategory = serviceCategory;
//	}
	public List<String> getServiceClassifications() {
		return serviceClassifications;
	}
	public void setServiceClassifications(List<String> serviceClassifications) {
		this.serviceClassifications = serviceClassifications;
	}
	
	 // Key	
		public void setKey(String oitServiceId) {
			this.key = KeyFactory.createKey("OitService", oitServiceId);	
		}

		public Key getKey() {
	        return key;
	    }
	
		
//		public void Save() {
//			
//			EntityManager em = EMF.get().createEntityManager();
//						
//		// BEGIN TRANSACTION RECORD FOR ROLLBACK IF NEEDED 
//			EntityTransaction txn = em.getTransaction();			
//			txn.begin();
//		
//			try {
//			  em.persist(this);
//			
//			// COMMIT ENTRIES
//			txn.commit();
//		
//		    } finally {
//			  if (txn.isActive()) { txn.rollback(); }
//		    }
//			
//		    em.close();		
//		}

}
