package com.ssafy.happyhouse.model;

public class HouseDealDto {
	private String no;
	private String dong;
	private String aptName;
	private String code;
	private String dealAmount;
	private String buildYear;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	private String jibun;
	private String type;
	private String rentMoneny;
	
	public HouseDealDto() {
		// TODO Auto-generated constructor stub
	}

	public HouseDealDto(String dealAmount, String area, String dealYear, String dealMonth, String dealDay) {
		super();
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
	}

	public HouseDealDto(String no, String dong, String aptName, String code, String dealAmount, String buildYear,
			String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type,
			String rentMoneny) {
		super();
		this.no = no;
		this.dong = dong;
		this.aptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.jibun = jibun;
		this.type = type;
		this.rentMoneny = rentMoneny;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getDealYear() {
		return dealYear;
	}

	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}

	public String getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}

	public String getDealDay() {
		return dealDay;
	}

	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRentMoneny() {
		return rentMoneny;
	}

	public void setRentMoneny(String rentMoneny) {
		this.rentMoneny = rentMoneny;
	}
}
