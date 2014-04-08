package gov.oit.storefrontweb.model;

import gov.oit.storefrontweb.shared.EMF;
import gov.oit.storefrontweb.shared.ObjectValidator;

import java.util.List;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity(name = "OperatingSystem") 
public class OperatingSystem {
	

	// Columns
	@Id
    private Key key;
	
	@Column(nullable=false)
	private String osKey;
	
	private String osName;	
	private String version;

	// Constructors
	
	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public OperatingSystem(String osKey) {
		this.osKey = osKey;
		this.setKey(osKey);
	}
	
	
	// OS Name
	public String getOSName() {
		
		return osName;
		
	}

	public void setOSName(String osName) {
		this.osName = osName;
	}
	

   // Key	
	public void setKey(String osKey) {
		this.key = KeyFactory.createKey("OperatingSystem", osKey);	
	}

	public Key getKey() {
        return key;
    }
	
	
	// Active Record
	
	public void Save() {
		
		EntityManager em = EMF.get().createEntityManager();
					
	// BEGIN TRANSACTION RECORD FOR ROLLBACK IF NEEDED 
		EntityTransaction txn = em.getTransaction();			
		txn.begin();
	
		try {
		  em.persist(this);
		
		// COMMIT ENTRIES
		txn.commit();
	
	    } finally {
		  if (txn.isActive()) { txn.rollback(); }
	    }
		
	    em.close();		
	}
	
	public void Delete() {
	
	}
	
	public List<OperatingSystem> Search(String osKey) {
		return null;
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
