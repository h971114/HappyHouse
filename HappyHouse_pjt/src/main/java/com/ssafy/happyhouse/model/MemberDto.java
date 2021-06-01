package com.ssafy.happyhouse.model;

public class MemberDto {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private int dongcode;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String id, String password, String name, String address, String phoneNumber, int dongcode) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dongcode = dongcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getDongcode() {
		return dongcode;
	}

	public void setDongcode(int dongcode) {
		this.dongcode = dongcode;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", dongcode=" + dongcode + "]";
	}
}
