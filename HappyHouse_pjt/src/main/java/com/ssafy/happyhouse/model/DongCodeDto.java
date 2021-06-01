package com.ssafy.happyhouse.model;

public class DongCodeDto {
	private String dongcode;
	private String dong;
	public DongCodeDto() {
		super();
	}
	public DongCodeDto(String dongcode, String dong) {
		super();
		this.dongcode = dongcode;
		this.dong = dong;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
}
