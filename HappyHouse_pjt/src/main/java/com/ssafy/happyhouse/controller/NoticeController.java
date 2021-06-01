package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;
import com.ssafy.util.PageNavigation;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService service;

	@RequestMapping(value = "/notice", method=RequestMethod.GET)
	protected String process(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, String> map, Model model) throws  IOException, ServletException {
	request.setCharacterEncoding("UTF-8");
	String act = request.getParameter("act");
	System.out.println("안녕"+act);
	if(act==null || act.equals("list")) {
		String spp = map.get("10");
		System.out.println(spp);
		map.put("spp", spp != null ? spp : "10");//sizePerPage
		List<NoticeDto> list = null;
//		JSONArray arr = new JSONArray();
//		PrintWriter out = response.getWriter();
		try {
			list = service.getNoticeList(map);
			PageNavigation pageNavigation = service.makePageNavigation(map);
			model.addAttribute("list", list);
			model.addAttribute("navigation", pageNavigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("안녕"+list.get(0));
		//request.setAttribute("list", list);
		return "notice/notice_list";
		//request.getRequestDispatcher("/notice/notice_list.jsp").forward(request, response);
	}else if(act.equals("detail")) {
		String no = request.getParameter("no");
		int n_no = -1;
		NoticeDto notice = null;
		try {
			if(no!=null) n_no = Integer.parseInt(no);
			notice = service.getNotice(n_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(notice.getContent());
		request.setAttribute("notice", notice);
		return "notice/notice_detail";
		//request.getRequestDispatcher("/notice/notice_detail.jsp").forward(request, response);
	}else if(act.equals("preview")) {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<NoticeDto> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = service.getNoticeList();
			for(NoticeDto dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("no", dto.getN_no());
				obj.put("title", dto.getTitle());
				obj.put("content", dto.getContent());
				System.out.println(dto.getTitle());
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
	}
	return "notice/notice_list";
}
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public String getwriteform() {

		return "notice/notice_write";
	}
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title);
		NoticeDto notice = new NoticeDto(title, null, content);
		try {
			service.insert(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/notice?act=list&pg=1";
	//	request.getRequestDispatcher("/notice?act=list").forward(request, response);
		}
}
