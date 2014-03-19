package gov.oit.storefrontweb.model;

import javax.persistence.*;

@Entity(name = "SPKeyword") 
public class SPKeyword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spKeywordKey;
	
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
