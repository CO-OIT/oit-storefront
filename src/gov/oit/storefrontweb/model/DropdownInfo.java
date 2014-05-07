package gov.oit.storefrontweb.model;

public class DropdownInfo {
	
	private String _description;
	private String _key;
	private Boolean _selected;
	private String _category;
	private Integer _order;
	
	public DropdownInfo(String key, String description, String category, Boolean selected, Integer order) {
		this._key = key;
		this._description = description;
		this._selected = selected;	
		this._order = order;
		this._category = category;
	}
	
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public String get_key() {
		return _key;
	}
	public void set_key(String _key) {
		this._key = _key;
	}
	public Boolean get_selected() {
		return _selected;
	}
	public void set_selected(Boolean _selected) {
		this._selected = _selected;
	}

	public String get_category() {
		return _category;
	}

	public void set_category(String _category) {
		this._category = _category;
	}

	public Integer get_order() {
		return _order;
	}

	public void set_order(Integer _order) {
		this._order = _order;
	}
	
	

}
