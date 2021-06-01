package com.ssafy.happyhouse.model;

public class HighSchoolDto {
	private String gugun;
	private double n_per;//일반
	private double t_per;//특목고
	private double j_per;//특성화고
	private double f_per;//자율고
	public HighSchoolDto() {
		super();
	}
	public HighSchoolDto(String gugun, double n_per, double t_per, double j_per, double f_per) {
		super();
		this.gugun = gugun;
		this.n_per = n_per;
		this.t_per = t_per;
		this.j_per = j_per;
		this.f_per = f_per;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public double getN_per() {
		return n_per;
	}
	public void setN_per(double n_per) {
		this.n_per = n_per;
	}
	public double getT_per() {
		return t_per;
	}
	public void setT_per(double t_per) {
		this.t_per = t_per;
	}
	public double getJ_per() {
		return j_per;
	}
	public void setJ_per(double j_per) {
		this.j_per = j_per;
	}
	public double getF_per() {
		return f_per;
	}
	public void setF_per(double f_per) {
		this.f_per = f_per;
	}
	@Override
	public String toString() {
		return "HighSchoolDto [gugun=" + gugun + ", n_per=" + n_per + ", t_per=" + t_per + ", j_per=" + j_per
				+ ", f_per=" + f_per + "]";
	}
}
