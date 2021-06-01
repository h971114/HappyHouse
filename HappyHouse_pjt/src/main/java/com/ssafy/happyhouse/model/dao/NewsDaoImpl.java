package com.ssafy.happyhouse.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.NewsDto;

@Repository
public class NewsDaoImpl implements NewsDao {
	
	@Autowired
	SqlSession sqlSession;	
	
	@Override
	public List<NewsDto> getNews() throws Exception {
		Document doc = Jsoup.connect("https://realestate.daum.net/news/all").get();

		List<NewsDto> newsList = new ArrayList<>();;
		
		Elements contents = doc.select("ul.list_live li");
		
		
		int count = 0;
		for(Element article : contents) {
			if(count == 5) {
				break;
			}
			Elements articleSpan = article.select("span");
			String dateString = articleSpan.attr("data-time");
			String year = dateString.substring(0,4);
			String month = dateString.substring(4,6);
			String day = dateString.substring(6,8);
			String date = year + "." + month + "." + day;
			
			Elements articleA = article.select("a");
			String url = articleA.attr("abs:href");
			
			Elements articleStrong = article.select("strong.tit a");
			String title = articleStrong.get(0).ownText();
			
			NewsDto nd = new NewsDto(title, url, date);
			newsList.add(nd);
			
			count++;
			
			try {
				sqlSession.insert("news.insert", nd);
			} catch (Exception e) {
				System.out.println("fail");
			}
	
		}
		
		return newsList;
	}

	@Override
	public List<NewsDto> getNewsList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("news.selectList");
	}

}
