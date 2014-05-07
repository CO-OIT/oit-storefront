package gov.oit.storefrontweb.manager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import gov.oit.storefrontweb.model.AppInfoDetail;

public class AppInfoManager {
	
	private static final String ENT_APP_INFO_DETAIL = "AppInfoDetail";
	
	public void saveAppInfoDetail(AppInfoDetail appInfoDetail) {

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 String strKey = this.getUniqueKey(appInfoDetail.get_key()); 
		 
		 Entity ent = new Entity(ENT_APP_INFO_DETAIL, strKey);
		 
		 //TODO: Make sure there are not duplicate items for the category
		 
	}
	
	private String getUniqueKey(String baseKey) {
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
	
	

}
