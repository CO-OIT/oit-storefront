package gov.oit.storefrontweb.model;

public class AppInfoDetail {

	private String _key;
	private String _detailShortDescription;
	private String _detailLongDescription;
	private String _appInfoCategoryKey;
	private int _order;
	private Boolean _active;

    public String get_key() {
		return _key;
	}
	public void set_key(String _key) {
		this._key = _key;
	}
	public String get_detailShortDescription() {
		return _detailShortDescription;
	}
	public void set_detailShortDescription(String _detailShortDescription) {
		this._detailShortDescription = _detailShortDescription;
	}
	public String get_detailLongDescription() {
		return _detailLongDescription;
	}
	public void set_detailLongDescription(String _detailLongDescription) {
		this._detailLongDescription = _detailLongDescription;
	}
	public String get_appInfoCategoryKey() {
		return _appInfoCategoryKey;
	}
	public void set_appInfoCategoryKey(String _appInfoCategoryKey) {
		this._appInfoCategoryKey = _appInfoCategoryKey;
	}
	public int get_order() {
		return _order;
	}
	public void set_order(int _order) {
		this._order = _order;
	}
	public Boolean get_active() {
		return _active;
	}
	public void set_active(Boolean _active) {
		this._active = _active;
	}

}
