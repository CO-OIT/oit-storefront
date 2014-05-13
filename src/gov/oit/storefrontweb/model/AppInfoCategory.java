package gov.oit.storefrontweb.model;

public class AppInfoCategory {

	private String _key;
    private String _shortDescription;
    private String _longDescription;
    private Boolean _active;
	
    
    public AppInfoCategory(String key, String shortDescription, String longDescription, Boolean active) {
    	
    	this._active = active;
    	this._key = key;
    	this._longDescription = longDescription;
    	this._shortDescription = shortDescription;
    }
    
    public String get_key() {
		return _key;
	}
	public void set_key(String _key) {
		this._key = _key;
	}
	public String get_shortDescription() {
		return _shortDescription;
	}
	public void set_shortDescription(String _shortDescription) {
		this._shortDescription = _shortDescription;
	}
	public String get_longDescription() {
		return _longDescription;
	}
	public void set_longDescription(String _longDescription) {
		this._longDescription = _longDescription;
	}
	public Boolean get_active() {
		return _active;
	}
	public void set_active(Boolean _active) {
		this._active = _active;
	}

}
package gov.oit.storefrontweb.model;

public class AppInfoCategory {

	private String _key;
    private String _shortDescription;
    private String _longDescription;
    private Boolean _active;
	
    public String get_key() {
		return _key;
	}
	public void set_key(String _key) {
		this._key = _key;
	}
	public String get_shortDescription() {
		return _shortDescription;
	}
	public void set_shortDescription(String _shortDescription) {
		this._shortDescription = _shortDescription;
	}
	public String get_longDescription() {
		return _longDescription;
	}
	public void set_longDescription(String _longDescription) {
		this._longDescription = _longDescription;
	}
	public Boolean get_active() {
		return _active;
	}
	public void set_active(Boolean _active) {
		this._active = _active;
	}

}
