package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.NewsDto;
import com.ssafy.happyhouse.model.service.HouseMapService;
import com.ssafy.happyhouse.model.service.NewsService;

@Controller
public class MainController {
	@Autowired
	private HouseMapService service;
	
	@Autowired
	private NewsService newsService;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		try {
			
			List<NewsDto> newsList = newsService.getNews();
			
			model.addAttribute("news", newsList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "index";
	}
	/*public String index() {
	  return "index";
	}*/
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String main(String dong, Model model) {
//		try {
//			List<HouseInfoDto> list = service.getAptInDong(dong) ;
//			model.addAttribute("lsit",list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	  return "search/search";
//	}

//	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	protected String mainsearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		System.out.println("dong : " + dong);
		List<HouseInfoDto> list = null;
		try {
			list = service.getAptInDong(dong);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		return "search/search";
	}
}
