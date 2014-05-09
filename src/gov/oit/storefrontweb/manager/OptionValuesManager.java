package gov.oit.storefrontweb.manager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import gov.oit.storefrontweb.model.AppInfoCategory;
import gov.oit.storefrontweb.model.AppInfoDetail;
import gov.oit.storefrontweb.helpers.*;

public class OptionValuesManager {
	
    public void saveAppInfoCategory(AppInfoCategory appInfoCategory) throws EntityNotFoundException {
    	
    	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 
		 Entity ent = new Entity(Constants.ENT_APP_INFO_CATEGORY, appInfoCategory.get_key());

		 ent.setProperty("shortDescription", appInfoCategory.get_shortDescription());
		 ent.setProperty("longDescription", appInfoCategory.get_longDescription());
		 ent.setProperty("active", appInfoCategory.get_active());
		 
		 ds.put(ent);		 
    }
	
	
	public void saveAppInfoDetail(AppInfoDetail appInfoDetail) throws EntityNotFoundException {

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 String strKey = this.getUniqueKey(appInfoDetail.get_key()); 
		 
		 Entity ent = new Entity(Constants.ENT_APP_INFO_DETAIL, strKey);
		 ent.setProperty("detailShortDescription", appInfoDetail.get_detailShortDescription());
		 ent.setProperty("detailLongDescription", appInfoDetail.get_detailLongDescription());
		 ent.setProperty("active", appInfoDetail.get_active());		 
		 ent.setProperty("appInfoCategoryKey", appInfoDetail.get_appInfoCategoryKey());
		 ent.setProperty("order", appInfoDetail.get_order());

         ds.put(ent);		 
	}
	
	private String getUniqueKey(String baseKey) throws EntityNotFoundException {
		  String candidateName = "";

		  //See if there's already an 
		  DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		  
		  Key key = KeyFactory.stringToKey(baseKey);
		  Entity en = ds.get(key);
		   
		  //in case it's already in the datastore
		  int counter = 1;
		  String newName = "";
		  
        while (en != null) {
         
      	  newName = String.format("%s%d", baseKey, counter);                  
			  
	      key = KeyFactory.stringToKey(newName);
			  
			  en = ds.get(key);
      	  
		  if (null == en) {
			  candidateName = newName;
		  }
		  
		  else {
			 newName = ""; 
	      	 counter++;            	  
		  }
		  
        }
		 
		  return candidateName;
	  }
	  
	}
	
