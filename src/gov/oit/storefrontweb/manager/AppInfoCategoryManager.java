package gov.oit.storefrontweb.manager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import gov.oit.storefrontweb.helpers.Constants;
import gov.oit.storefrontweb.model.AppInfoCategory;

public class AppInfoCategoryManager {

	private static final String COL_SHORT_DESCRIPTION = "shortDescription";
	private static final String COL_LONG_DESCRIPTION = "longDescription";
	private static final String COL_ACTIVE = "active";
	private static final String COL_KEY = "key";
		
	public void save(AppInfoCategory appInfoCategory) {
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		Entity ent = new Entity(Constants.ENT_APP_INFO_CATEGORY,
				appInfoCategory.get_key());

		ent.setProperty(COL_SHORT_DESCRIPTION,
				appInfoCategory.get_shortDescription());
		ent.setProperty(COL_LONG_DESCRIPTION,
				appInfoCategory.get_longDescription());

		ent.setProperty(COL_ACTIVE, appInfoCategory.get_active());

		ds.put(ent);
	}

	public AppInfoCategory getAppInfoCategory(String strKey) throws EntityNotFoundException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.stringToKey(strKey);
        Entity ent = null;
		
		try {
			ent = ds.get(key);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		AppInfoCategory appInfoCategory = this.convertEntityToAppInfoCategory(ent);
		return appInfoCategory;

	}
	
	public void delete(String strKey) throws EntityNotFoundException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.stringToKey(strKey);
        Entity ent = null;
		
		try {
			ent = ds.get(key);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		ent.setProperty(COL_ACTIVE, false);
		ds.put(ent);
	}

	private AppInfoCategory convertEntityToAppInfoCategory(Entity ent) {
		AppInfoCategory appInfoCategory = new AppInfoCategory(KeyFactory.keyToString(ent.getKey()), ent.getProperty(COL_SHORT_DESCRIPTION).toString(), ent.getProperty(COL_LONG_DESCRIPTION).toString(), (Boolean)ent.getProperty(COL_ACTIVE));
		return appInfoCategory;
	}

}
