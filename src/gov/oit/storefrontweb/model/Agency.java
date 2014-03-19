package gov.oit.storefrontweb.model;

import java.util.List;

import javax.persistence.*;

@Entity(name = "Agency") 
public class Agency {
	
	@Id
	private String agencyKey;
	
	private String agencyName;
	
/*	@OneToMany(mappedBy="agency")
	private List<OitService> oitServices;*/

	public String getAgencyName() {
		
		return agencyName;
		
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public void setAgencyKey(String agencyKey) {
		this.agencyKey = agencyKey;
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
