package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.NewsDto;
import com.ssafy.happyhouse.model.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsService service;
	
	@GetMapping("/news_list")
	public String newList(Model model) {
		try {
			List<NewsDto> list = new ArrayList<>();
					
			list = service.getNewsList();
			for(NewsDto nd : list) {
				System.out.println(nd.getDateTime());
			}
			
			model.addAttribute("newslist", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "news/news_list";
	}
}
