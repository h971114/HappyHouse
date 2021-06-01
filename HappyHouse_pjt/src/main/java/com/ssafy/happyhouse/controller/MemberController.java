package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.SubwayDto;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
//	@GetMapping("/index")
//	public String registForm() {
//	  return "index";
//	}
//	
	@RequestMapping(value="/loginmodal", method = RequestMethod.GET)
	public String loginmodal() {
	   return "login/loginModal";    
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, HttpSession session, HttpServletResponse resp, Model model) throws IOException {
		try {
			resp.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = resp.getWriter(); 
			
			int loginchk = service.loginCheck(id, pw);
			if(loginchk == 1) {
				session.setAttribute("login", id);
				System.out.println("로그인 성공");
				model.addAttribute("msg", "정상적으로 로그인 되었습니다.");
				
				MemberDto member = service.search(id);
				Map<String,String> map = new HashMap<>();
				
				String intArea = "";
				String lat = "";
				String lng = "";
				
				int rank = 0;
				String t_per = null;
				List<SubwayDto> subways = null;
				if(member.getDongcode() != 0) {
					intArea = service.getArea(member.getDongcode());
					map = service.getLocate(member.getDongcode());
					lat = map.get("lat");
					lng = map.get("lng");
					
					t_per = service.getGun(member.getDongcode());
					if(t_per.equals(""))
						t_per="0";
					rank = service.getRank(member.getDongcode());
					subways = service.getSubway(member.getDongcode());
				}
				//String dongsplit[] = intArea.split(" ");
				//String name = dongsplit[2];
				
				session.setAttribute("dongName", intArea);
				session.setAttribute("lat", lat);
				session.setAttribute("lng", lng);
				
				session.setAttribute("t_per", t_per);
				session.setAttribute("rank", rank);
	            session.setAttribute("subways",subways);
				//System.out.println("관심지역 : " + intArea);
				//model.addAttribute("intArea", intArea);
				
				return "redirect:/index";
			}
			else {
				System.out.println("로그인 실패!");
				model.addAttribute("msg", "아이디 또는 패스워드가 틀렸습니다.");
				writer.println("<script>alert('ID와 비밀번호를 확인해주세요.'); history.back();</script>"); 
				writer.close();
				return "";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "로그인 실패.");
			//return "error/error";
			return "redirect:/index";
		}
	}
	
	/*@PostMapping("/login")
	public String login(String id, String pw, HttpSession session, Model model) {
		try {
			int loginchk = service.loginCheck(id, pw);
			if(loginchk == 1) {
				session.setAttribute("login", id);
				System.out.println("로그인 성공");
				model.addAttribute("msg", "정상적으로 로그인 되었습니다.");
			}
			else {
				System.out.println("로그인 실패!");
				model.addAttribute("msg", "아이디 또는 패스워드가 틀렸습니다.");
			}
			return "redirect:/index";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "로그인 실패.");
			return "error/error";
		}
	}*/
	
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		//session.invalidate();
		session = request.getSession();
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("/regist")
    public String joinForm() {
       return "member/member_regist";	
    }
	
	@PostMapping("/regist")
	public String joinMember(MemberDto member, String interestArea, Model model) {
		try {
			int dongcode = 0;
			try {
				dongcode = service.searchArea(interestArea);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			member.setDongcode(dongcode);
			service.regist(member);
			model.addAttribute("member", member);
			return "redirect:/index";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "회원 등록에 실패했습니다.");
	        //return "ssafy/error/error.jsp";
			return "redirect:/index";
		}
	}
	
	@GetMapping("/myPage")
	public String myPage(HttpServletRequest request, Model model) {
		try {
			System.out.println("mypage 진입");
			
			String id = (String)request.getSession().getAttribute("login");	
			
			System.out.println(id);
			MemberDto member = service.search(id);
			
			String intArea = "";
			if(member.getDongcode() != 0) {
				intArea = service.getArea(member.getDongcode());
			}
			else {
				intArea="관심지역이 설정되지 않았습니다.";
			}
			
			model.addAttribute("member", member);
			model.addAttribute("intArea", intArea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "member/member_myPage";
	}
	
	/*@GetMapping("/myPage")
	public String myPage(String id, Model model) {
		try {
			System.out.println("mypage 진입");
			
			model.addAttribute("member", service.search(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "member/member_myPage";
	}*/
	
	
	@GetMapping("/modify")
	public String modifyForm(HttpServletRequest request, Model model) {
		try {
			String id = (String)request.getSession().getAttribute("login");	
			
			MemberDto member = service.search(id);
			
			String intArea = "";
			if(member.getDongcode() != 0) {
				intArea = service.getArea(member.getDongcode());
			}
			else {
				intArea="관심지역이 설정되지 않았습니다.";
			}
			
			model.addAttribute("member", member);
			model.addAttribute("intArea", intArea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "member/member_modify";
	}
	
	@PostMapping("/modify")
	public String modify(MemberDto member, String interestArea, HttpServletRequest request, HttpSession session) {
		try {
			
			String id = (String)request.getSession().getAttribute("login");	
			
			int dongcode = service.searchArea(interestArea);
			
			member.setId(id);	
			member.setDongcode(dongcode);
					
			service.modify(member);
			
			Map<String,String> map = new HashMap<>();
			
			String intArea = "";
			String lat = "";
			String lng = "";
			
			if(member.getDongcode() != 0) {
				intArea = service.getArea(member.getDongcode());
				map = service.getLocate(member.getDongcode());
				lat = map.get("lat");
				lng = map.get("lng");
			}
			
			session.setAttribute("dongName", intArea);
			session.setAttribute("lat", lat);
			session.setAttribute("lng", lng);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/member/myPage";
	}
	
	@GetMapping("/remove")
	public String removeForm(String id) {
//		System.out.println(id);
//		try {
//			service.remove(id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "error/error";
//		}
		return "member/member_delete";
	}
	
	@PostMapping("/remove")
	public String remove(HttpServletRequest request) {
		
		try {
			String id = (String)request.getSession().getAttribute("login");	
			
			service.remove(id);			
			request.getSession().invalidate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return "error/error";
		}
		
		
		return "redirect:/index";
	}
}
