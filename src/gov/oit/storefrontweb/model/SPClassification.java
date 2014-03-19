package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "SPClassification") 
public class SPClassification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spClassificationKey;	
	private String classificationDescription;
	private ServiceClassificationArea serviceClassificationArea;
	public String getClassificationDescription() {
		return classificationDescription;
	}
	public void setClassificationDescription(String classificationDescription) {
		this.classificationDescription = classificationDescription;
	}
	public ServiceClassificationArea getServiceClassificationArea() {
		return serviceClassificationArea;
	}
	public void setServiceClassificationArea(ServiceClassificationArea serviceClassificationArea) {
		this.serviceClassificationArea = serviceClassificationArea;
	}
}
