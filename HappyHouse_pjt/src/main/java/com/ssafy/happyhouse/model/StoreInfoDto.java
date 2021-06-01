package com.ssafy.happyhouse.model;

public class StoreInfoDto {
	private String storenum;
	private String storename;
	private String storeloc;
	private String storecodename;
	private String sido_code;
	private String gugun_code;
	private String dongcode;
	private String lat;
	private String ing;
	
	
	public StoreInfoDto() {
		super();
	}


	public StoreInfoDto(String storenum, String storename, String storeloc, String storecodename, String sido_code,
			String gugun_code, String dongcode, String lat, String ing) {
		super();
		this.storenum = storenum;
		this.storename = storename;
		this.storeloc = storeloc;
		this.storecodename = storecodename;
		this.sido_code = sido_code;
		this.gugun_code = gugun_code;
		this.dongcode = dongcode;
		this.lat = lat;
		this.ing = ing;
	}


	public String getStorenum() {
		return storenum;
	}


	public void setStorenum(String storenum) {
		this.storenum = storenum;
	}


	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
	}


	public String getStoreloc() {
		return storeloc;
	}


	public void setStoreloc(String storeloc) {
		this.storeloc = storeloc;
	}


	public String getStorecodename() {
		return storecodename;
	}


	public void setStorecodename(String storecodename) {
		this.storecodename = storecodename;
	}


	public String getSido_code() {
		return sido_code;
	}


	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}


	public String getGugun_code() {
		return gugun_code;
	}


	public void setGugun_code(String gugun_code) {
		this.gugun_code = gugun_code;
	}


	public String getDongcode() {
		return dongcode;
	}


	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getIng() {
		return ing;
	}


	public void setIng(String ing) {
		this.ing = ing;
	}

}
