package com.ssafy.happyhouse.model;

public class NewsDto {
	private String newsTitle;
	private String newsLink;
	private String dateTime;
	
	public NewsDto() {
		// TODO Auto-generated constructor stub
	}

	public NewsDto(String newsTitle, String newsLink, String dateTime) {
		super();
		
		this.newsTitle = newsTitle;
		this.newsLink = newsLink;
		this.dateTime = dateTime;
	}



	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "NewsDto [newsTitle=" + newsTitle + ", newsLink=" + newsLink + ", dateTime=" + dateTime + "]";
	}

}
