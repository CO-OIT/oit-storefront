package gov.oit.storefrontweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity(name = "AppInfoHeading") 
public class AppInfoHeading extends ActiveRecord {

	@Id
    private Key key;
	
	private String appInfoHeadingId;
	public String getAppInfoHeadingId() {
		return appInfoHeadingId;
	}

	public void setAppInfoHeadingId(String appInfoHeadingId) {
		this.appInfoHeadingId = appInfoHeadingId;
	}

	public String getHeadingShortDescription() {
		return headingShortDescription;
	}

	public void setHeadingShortDescription(String headingShortDescription) {
		this.headingShortDescription = headingShortDescription;
	}

	public String getHeadingLongDescription() {
		return headingLongDescription;
	}

	public void setHeadingLongDescription(String headingLongDescription) {
		this.headingLongDescription = headingLongDescription;
	}

	private String headingShortDescription;
	private String headingLongDescription;
	
	public AppInfoHeading(String appInfoHeadingId) {
		this.appInfoHeadingId = appInfoHeadingId;
		this.setKey(appInfoHeadingId);
	}
	
	   // Key	
		public void setKey(String appInfoHeadingId) {
			this.key = KeyFactory.createKey("AppInfoHeading", appInfoHeadingId);	
		}

		public Key getKey() {
	        return key;
	    }
}
