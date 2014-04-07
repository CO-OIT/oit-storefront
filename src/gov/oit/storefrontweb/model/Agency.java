package gov.oit.storefrontweb.model;

import java.util.List;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity(name = "Agency") 
public class Agency {
	

	// Columns

	@Id
    private Key key;
	
	@Column(nullable=false)
	private String agencyCode;
	
	private String agencyName;
	
/*	@OneToMany(mappedBy="agency")
	private List<OitService> oitServices;*/

	// Constructors
	
	public Agency(String agencyCode) {
		this.agencyCode = agencyCode;
		this.setKey(agencyCode);
	}
	
	
	// Agency Name
	public String getAgencyName() {
		
		return agencyName;
		
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
	// Agency Code
	
	private void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	
	public String getAgencyCode() {
		return agencyCode;
	}

   // Key	
	public void setKey(String agencyCode) {
		this.key = KeyFactory.createKey("Agency", agencyCode);	
	}

	public Key getKey() {
        return key;
    }
	
	public void commit() {
	
		
		EntityManagerFactory emf =
		        Persistence.createEntityManagerFactory("transactions-optional");
		
		//EntityManagerFactory emf = EMF.get(); 
		EntityManager em = null;
		
		try {
		em = emf.createEntityManager();
		
		//commit data to datastore
		em.persist(this);
		} 
		
		finally {
		if (em != null) em.close();
		}
	
	}

}
