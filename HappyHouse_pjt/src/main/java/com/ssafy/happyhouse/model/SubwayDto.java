package com.ssafy.happyhouse.model;

public class SubwayDto {
	private String line;
	private String name;
	private String address;
	public SubwayDto() {
		super();
	}
	public SubwayDto(String line, String name, String address) {
		super();
		this.line = line;
		this.name = name;
		this.address = address;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
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
	@Override
	public String toString() {
		return "SubwayDto [line=" + line + ", name=" + name + ", address=" + address + "]";
	}
}
