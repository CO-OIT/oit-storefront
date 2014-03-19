package gov.oit.storefrontweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ServiceClassificationArea") 
public class ServiceClassificationArea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spClassificationAreaKey;
	
	private String spClassificationAreaDescription;

	public String getSpClassificationAreaDescription() {
		return spClassificationAreaDescription;
	}

	public void setSpClassificationAreaDescription(
			String spClassificationAreaDescription) {
		this.spClassificationAreaDescription = spClassificationAreaDescription;
	}

}
