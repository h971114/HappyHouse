package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

@Controller
public class HouseMapController  {
	@Autowired
	private HouseMapService service;
	
	@RequestMapping(value = "/map", method=RequestMethod.GET)
	//@GetMapping("/map")
	//@ResponseBody
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setCharacterEncoding("UTF-8");
	String act = request.getParameter("act");
	System.out.println(act);
	if("sido".equals(act)) {
		PrintWriter out = response.getWriter();
		List<SidoGugunCodeDto> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = service.getSido();
			if(list==null) System.out.println("null");
			else System.out.println(list.get(1));
			for(SidoGugunCodeDto dto : list) {
				JSONObject obj = new JSONObject();
				
				obj.put("sido_code", dto.getSido_code());
				obj.put("sido_name", dto.getSido_name());
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr.toJSONString());
			out.close();
		}
	}//sido
	else if("gugun".equals(act)) {
		String sido = request.getParameter("sido");
		PrintWriter out = response.getWriter();
		List<SidoGugunCodeDto> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = service.getGugunInSido(sido);
			for(SidoGugunCodeDto dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("gugun_code", dto.getGugun_code());
				obj.put("gugun_name", dto.getGugun_name());
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr.toJSONString());
			out.close();
		}
	}//gugun
	else if("dong".equals(act)) {
		String gugun = request.getParameter("gugun");
		PrintWriter out = response.getWriter();
		List<HouseInfoDto> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = service.getDongInGugun(gugun);
			for(HouseInfoDto dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("code", dto.getCode());
				obj.put("dong", dto.getDong());
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr.toJSONString());
			out.close();
		}
	}//dong
	else if("apt".equals(act)) {
		System.out.println("apt");
		String dong = request.getParameter("dong");
		PrintWriter out = response.getWriter();
		List<HouseInfoDto> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = service.getAptInDong(dong);
			for(HouseInfoDto dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("no", dto.getNo());
				obj.put("dong", dto.getDong());
				obj.put("aptName", dto.getAptName());
				obj.put("code", dto.getCode());
				obj.put("jibun", dto.getJibun());
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
	}//apt
}//process
//	public void getSido(@RequestParam("act") String act, HttpServletResponse response) throws IOException {
//		PrintWriter out = response.getWriter();
//		List<SidoGugunCodeDto> list = null;
//		JSONArray arr = new JSONArray();
//		try {
//			list = service.getSido();
//			for(SidoGugunCodeDto dto : list) {
//				JSONObject obj = new JSONObject();
//				obj.put("sido_code", dto.getSidoCode());
//				obj.put("sido_name", dto.getSidoName());
//				arr.add(obj);
//			}
//		} catch (Exception e) {
//			arr = new JSONArray();
//			JSONObject obj = new JSONObject();
//			obj.put("message_code", "-1");
//			arr.add(obj);
//			e.printStackTrace();
//		} finally {
//			out.print(arr.toJSONString());
//			out.close();
//		}
//
//	}
//	@RequestMapping(value = "/getgugun", method=RequestMethod.GET)
//	public String getGugunInSido(@RequestParam("act") String act,String sido,Model model) {
//		try {
//			List<SidoGugunCodeDto> list = service.getGugunInSido(sido);
//
//			
//			model.addAttribute("housemap",list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "search";
//	}
//	@RequestMapping(value = "/getdong", method=RequestMethod.GET)
//	public String getDongInGugun(@RequestParam("act") String act,String gugun,Model model) {
//		try {
//			List<HouseInfoDto> list = service.getDongInGugun(gugun);
//			model.addAttribute("housemap",list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "search";
//	}
//	@RequestMapping(value = "/getapt", method=RequestMethod.POST)
//	public String getAptInDong(@RequestParam("act") String act,String dong,Model model) {
//		try {
//			List<HouseInfoDto> list = service.getAptInDong(dong);
//			model.addAttribute("housemap",list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "search/search";
//	}
//	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		String act = request.getParameter("act");
//		System.out.println(act);
//		if("sido".equals(act)) {
//			PrintWriter out = response.getWriter();
//			List<SidoGugunCodeDto> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = HouseMapServiceImpl.getHouseMapService().getSido();
//				for(SidoGugunCodeDto dto : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("sido_code", dto.getSidoCode());
//					obj.put("sido_name", dto.getSidoName());
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				out.print(arr.toJSONString());
//				out.close();
//			}
//		}//sido
//		else if("gugun".equals(act)) {
//			String sido = request.getParameter("sido");
//			PrintWriter out = response.getWriter();
//			List<SidoGugunCodeDto> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = HouseMapServiceImpl.getHouseMapService().getGugunInSido(sido);
//				for(SidoGugunCodeDto dto : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("gugun_code", dto.getGugunCode());
//					obj.put("gugun_name", dto.getGugunName());
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				out.print(arr.toJSONString());
//				out.close();
//			}
//		}//gugun
//		else if("dong".equals(act)) {
//			String gugun = request.getParameter("gugun");
//			PrintWriter out = response.getWriter();
//			List<HouseInfoDto> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = HouseMapServiceImpl.getHouseMapService().getDongInGugun(gugun);
//				for(HouseInfoDto dto : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("code", dto.getCode());
//					obj.put("dong", dto.getDong());
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				out.print(arr.toJSONString());
//				out.close();
//			}
//		}//dong
//		else if("apt".equals(act)) {
//			System.out.println("apt");
//			String dong = request.getParameter("dong");
//			PrintWriter out = response.getWriter();
//			List<HouseInfoDto> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = HouseMapServiceImpl.getHouseMapService().getAptInDong(dong);
//				for(HouseInfoDto dto : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("no", dto.getNo());
//					obj.put("dong", dto.getDong());
//					obj.put("aptName", dto.getAptName());
//					obj.put("code", dto.getCode());
//					obj.put("jibun", dto.getJibun());
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				System.out.println(arr.toJSONString());
//				out.print(arr.toJSONString());
//				out.close();
//			}			
//		}//apt
//	}//process

}