package gov.oit.storefrontweb.manager;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

import gov.oit.storefrontweb.model.ServiceOverview;

public class RunBookManager {

	public void saveServiceOverview(ServiceOverview serviceOverview) throws EntityNotFoundException {
		 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 String strKey = this.getUniqueKey("SO", serviceOverview.get_appName(), 
				 serviceOverview.get_agencyKey());
		 
		 Entity ent = new Entity("ServiceOverview", strKey);

		 ent.setProperty("appName", serviceOverview.get_appName());
		 ent.setProperty("agencyKey", serviceOverview.get_agencyKey());
		 ent.setProperty("catKey", serviceOverview.get_catKey());
		 ent.setProperty("functionalServiceKey", serviceOverview.get_functionalServiceKey());
		 ent.setProperty("businessOwner", serviceOverview.get_businessOwner());
		 ent.setProperty("portfolioKey", serviceOverview.get_portfolioKey());
		 ent.setProperty("priorityKey", serviceOverview.get_priorityKey());
         ent.setProperty("appArchKey", serviceOverview.get_appArchKey());
         ent.setProperty("webPlatformKey", serviceOverview.get_webPlatformKey());
         ent.setProperty("appPlatformKey", serviceOverview.get_appPlatformKey());
         ent.setProperty("portfolioManager", serviceOverview.get_portfolioManager());
         ent.setProperty("appManager", serviceOverview.get_appManager());
         ent.setProperty("solArchitect", serviceOverview.get_solArchitect());
         ent.setProperty("leadEngineer", serviceOverview.get_leadEngineer());
         ent.setProperty("t1Support", serviceOverview.get_t1Support());
         ent.setProperty("t2Support", serviceOverview.get_t2Support());
         ent.setProperty("t3Support", serviceOverview.get_t3Support());
		 ent.setProperty("dataClassification", serviceOverview.get_dataClassification());
		 ent.setProperty("databaseDeveloper", serviceOverview.get_databaseDeveloper());
		 ent.setProperty("databaseAdministrator", serviceOverview.get_databaseAdministrator());
		 ent.setProperty("lanClassKey", serviceOverview.get_lanClassKey());
		 ent.setProperty("siteGatewayKey", serviceOverview.get_siteGatewayKey());
		 ent.setProperty("dcVlanZone", serviceOverview.get_dcVlanZone());
		 ent.setProperty("agencyLanEngineer", serviceOverview.get_agencyLanEngineer());
		 ent.setProperty("dcLanEngineer", serviceOverview.get_dcLanEngineer());
		 ent.setProperty("secopsEngineer", serviceOverview.get_secopsEngineer());
		 ent.setProperty("serverPlatformKey", serviceOverview.get_serverPlatformKey());
		 ent.setProperty("hypervisorKey", serviceOverview.get_hypervisorKey());
		 ent.setProperty("hostOsKey", serviceOverview.get_hostOsKey());
		 ent.setProperty("guestOsKey", serviceOverview.get_guestOsKey());
		 ent.setProperty("serverHostingManager", serviceOverview.get_serverHostingManager());
		 ent.setProperty("serverAdmin", serviceOverview.get_serverAdmin());
		 ent.setProperty("storageAdmin", serviceOverview.get_storageAdmin());
		 
		 ds.put(ent);
	}
		//Retrieve/Get
		  //get by key
		  public ServiceOverview getServiceOverviewById(String strKey) throws EntityNotFoundException
		  {
			  Key key = KeyFactory.stringToKey(strKey);			  
			  DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			  Entity ent = ds.get(key);
			  
			  ServiceOverview serviceOverview = new ServiceOverview();
			 
			  //Here there be dragons
			  
			  
			  return serviceOverview;
			 			  
		  }
		  
		  //get by agency
		  public ServiceOverview getServiceOverviewByAgency(String agency) {
			  return null;
		  }
		  
		  //get by portfolio
		  public List<ServiceOverview> getServiceOverviewByPortfolio(String portfolioKey) {
			  return null;
		  }
		  
		  private String getUniqueKey(String kindCode, String appName, String agencyKey) throws EntityNotFoundException {
			  
			  String abbreviatedName = "";
			  String candidateName = "";

			  //If the appName is less than 3 characters, pad it out to 3.
			  if (appName.length() < 3) {            	  
            	  appName = String.format("%1$-" + 3 + "s", appName);
            	  appName = appName.replace(' ', 'X');
              }

			  //Get the first three characters of the app name, replace spaces with underscores,
			  //  convert to uppercase.
			  abbreviatedName = appName.substring(0, 3);
			  abbreviatedName = abbreviatedName.replace(' ', '_');
			  abbreviatedName = abbreviatedName.toUpperCase();
			  
			  //Create a candidate name for the key value in the format KIND-APP-AGENCY
			  candidateName = String.format("%s-%s-%s", kindCode, abbreviatedName, agencyKey.toUpperCase());
			  
			  //See if there's already an 
			  DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			  
			  Key key = KeyFactory.stringToKey(candidateName);
			  Entity en = ds.get(key);
			   
			  //in case it's already in the datastore
			  int counter = 1;
			  String newName = "";
			  
              while (en != null) {
               
            	  newName = String.format("%s%d", abbreviatedName, counter);                  
    			  
            	  //New candidate name will be KIND-APPn-AGENCY 
            	  candidateName = String.format("%s-%s-%s", kindCode, newName, agencyKey.toUpperCase());
    			  key = KeyFactory.stringToKey(candidateName);
    			  
    			  en = ds.get(key);
            	  
            	  counter++;            	  
              }
			 
			  return candidateName;
		  }
	}
