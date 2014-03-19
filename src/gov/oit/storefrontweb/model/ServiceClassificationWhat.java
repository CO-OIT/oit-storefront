package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "ServiceClassificationWhat") 
public class ServiceClassificationWhat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spClassificationWhatKey;
	
	private String classificationAreaDescription;

	public String getClassificationAreaDescription() {
		return classificationAreaDescription;
	}

	public void setClassificationAreaDescription(String classificationAreaDescription) {
		this.classificationAreaDescription = classificationAreaDescription;
	}
	
}
