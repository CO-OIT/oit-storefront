package gov.oit.storefrontweb.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

public class ServiceBridge extends ActiveRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	private String appInfoDetailId;
	private Long oitServiceKey;

}
