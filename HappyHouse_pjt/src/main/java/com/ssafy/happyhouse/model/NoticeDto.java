package com.ssafy.happyhouse.model;

public class NoticeDto {
	String n_no;
	String title;
	String hit;
	String content;
	
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}

	public NoticeDto(String title, String hit, String content) {
		super();
		this.title = title;
		this.hit = hit;
		this.content = content;
	}

	public String getN_no() {
		return n_no;
	}

	public void setN_no(String n_no) {
		this.n_no = n_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
