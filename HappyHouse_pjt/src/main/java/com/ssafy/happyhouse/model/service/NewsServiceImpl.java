package com.ssafy.happyhouse.model.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NewsDto;
import com.ssafy.happyhouse.model.dao.NewsDao;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao dao;
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	@PostConstruct
	public List<NewsDto> getNews() throws Exception {
		// TODO Auto-generated method stub
		return dao.getNews();	
	}

	@Override
	public List<NewsDto> getNewsList() throws Exception {
		// TODO Auto-generated method stub
		return dao.getNewsList();
	}

}
