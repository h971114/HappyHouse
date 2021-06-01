package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.StoreInfoDto;
import com.ssafy.happyhouse.model.service.StoreInfoService;
import com.ssafy.util.PageNavigation;

@Controller
public class StoreInfoController {
	@Autowired
	private StoreInfoService service;
	@RequestMapping(value="/storemodal", method = RequestMethod.GET)
	public String storemodal(HttpServletResponse response,HttpServletRequest request, @RequestParam Map<String, String> map, Model model) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		System.out.println(dong);
		String spp = map.get("10");
		System.out.println(spp);
		map.put("spp", spp != null ? spp : "10");//sizePerPage
		List<StoreInfoDto> list = null;
		JSONArray arr = new JSONArray();
		PrintWriter out = response.getWriter();

		try {
			list = service.getStoreInfo(dong,map);
			PageNavigation pageNavigation = service.makePageNavigation(map);
			model.addAttribute("list", list);
			model.addAttribute("navigation", pageNavigation);
		} catch (Exception e) {

			e.printStackTrace();
		} 

		//request.setAttribute("list", list);
	   return "search/storeModal";    
	}
}
