package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.StoreInfoDto;
import com.ssafy.happyhouse.model.dao.HouseDealDaoImpl;
import com.ssafy.happyhouse.model.service.HouseDealService;

@Controller
public class HouseDealContorller  {
	
	@Autowired
	private HouseDealService service;
	
	
//	public String deal(String code,String aptName,Model model) {
//		try {
//			model.addAttribute("housedeal",service.getDealInApt(Integer.parseInt(code),aptName));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "search_deatil";
//	}
//	

	@RequestMapping(value = "/deal", method=RequestMethod.GET)
	protected String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String act = request.getParameter("act");
		List<HouseDealDto> list = null;
		if(act==null) {
			String strCode = request.getParameter("code");
			int code = Integer.parseInt(strCode);
			String aptName = request.getParameter("aptName");
			PrintWriter out = response.getWriter();

			JSONArray arr = new JSONArray();
			try {
				list = service.getDealInApt(code,aptName);
				for(HouseDealDto dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("aptName", dto.getAptName());
					obj.put("dealAmount", dto.getDealAmount());
					obj.put("area", dto.getArea());
					obj.put("dealYear", dto.getDealYear());
					obj.put("dealMonth", dto.getDealMonth());
					obj.put("dealDay", dto.getDealDay());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				System.out.println(arr.toJSONString());
				out.print(arr.toJSONString());
				out.close();
			}			
		}//act==null
		//request.setAttribute("list", list);
		return "/search/search_detail";
	}//process
	
}
