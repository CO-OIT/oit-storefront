package gov.oit.storefrontweb.model;

import java.util.Map;

import gov.oit.storefrontweb.shared.EMF;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ActiveRecord {
	
public void save() {
		
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
	
    public Map<String, String> GetKVList(String lookup) {    	
    	return null;
    }

	public void Delete() {
	
	}

	

}
