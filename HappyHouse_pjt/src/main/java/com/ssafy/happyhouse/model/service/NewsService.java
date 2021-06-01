package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.NewsDto;

public interface NewsService {
public List<NewsDto> getNews() throws Exception;
	
	public List<NewsDto> getNewsList() throws Exception;
}
