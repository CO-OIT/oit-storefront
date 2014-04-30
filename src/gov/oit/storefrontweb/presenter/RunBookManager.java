package gov.oit.storefrontweb.presenter;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import gov.oit.storefrontweb.model.ServiceOverview;

public class RunBookManager {

	public void saveServiceOverview(ServiceOverview serviceOverview) {
		 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 Entity ent = new Entity("ServiceOverview");

		 ent.setProperty("agencyKey", serviceOverview.get_agencyKey());
		 
		 
		 
		 ds.put(ent);
	}
		//Retrieve/Get
		  //get by key
		  public ServiceOverview getServiceOverviewById(Long id)
		  {
			  return null;
		  }
		  
		  //get by agency
		  public ServiceOverview getServiceOverviewByAgency(String agency) {
			  return null;
		  }
		  
		  //get by portfolio
		  public List<ServiceOverview> getServiceOverviewByPortfolio(String portfolioKey) {
			  return null;
		  }
	}
