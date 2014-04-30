package gov.oit.storefrontweb.model;

import gov.oit.storefrontweb.shared.EMF;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TypedQuery;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity(name = "AppInfoDetail") 
public class AppInfoDetail extends ActiveRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	private String detailShortDescription;
	private String detailLongDescription;
	private String appInfoHeadingId;

	public String getAppInfoHeadingId() {
		return appInfoHeadingId;
	}

	public void setAppInfoHeadingId(String appInfoHeadingId) {
		this.appInfoHeadingId = appInfoHeadingId;
	}

	//Constructor
	public AppInfoDetail() {
	}
	
	 // Key	
//	public void setKey(String appInfoDetailId) {
//		this.key = KeyFactory.createKey("AppInfoDetail", appInfoDetailId);	
//	}

	public Key getKey() {
        return key;
    }
	
	public String getDetailShortDescription() {
		return detailShortDescription;
	}
	public void setDetailShortDescription(String detailShortDescription) {
		this.detailShortDescription = detailShortDescription;
	}
	public String getDetailLongDescription() {
		return detailLongDescription;
	}
	public void setDetailLongDescription(String detailLongDescription) {
		this.detailLongDescription = detailLongDescription;
	}
	
	//Active Record Methods
	
	@Override
	public Map<String, String> GetKVList(String lookup) {    	
		
	     return null;
		
     }

	public List<AppInfoDetail> listForHeadingType(String headingId) {

		List<AppInfoDetail> results = new ArrayList<AppInfoDetail>();
		EntityManager em = EMF.get().createEntityManager();
		//TypedQuery<Employee> myQuery;
		TypedQuery<AppInfoDetail> myQuery;
		
		try
		{
			String qry = String.format("SELECT d FROM AppInfoDetail d WHERE appInfoHeadingId = '%s' ORDER BY detailLongDescription", headingId);
			
			myQuery = em.createQuery(qry,AppInfoDetail.class);
							
			results = myQuery.getResultList();
							
			em.clear();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
		finally
		{
			em.close();
		}
		
		return results;	

	}
	
	
	
	
	
	

}
