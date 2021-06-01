package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.NewsDto;

public interface NewsDao {
public List<NewsDto> getNews() throws Exception;
	
	public List<NewsDto> getNewsList() throws Exception;
}
