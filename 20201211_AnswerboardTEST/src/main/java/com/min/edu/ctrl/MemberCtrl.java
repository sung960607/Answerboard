package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.service.IMemberService;
import com.min.edu.vo.MemberVO;

@Controller
public class MemberCtrl {

	@Autowired
	IMemberService IMService;

	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginMember.do" ,method = RequestMethod.POST)
	public String loginMember(String id, String pw,HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		MemberVO vo=IMService.loginMember(map);
		if(vo == null) {
			return "redirect:/login.do";
		}else {
			session.setAttribute("vo", vo);
			return "redirect:/answerboard.do";	
		}		
	}
	
	@RequestMapping(value = "/signUp.do",method = RequestMethod.GET)
	public String signUp() {
		return "signUp";
	}
	
	@RequestMapping(value = "/idCheck.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> idCheck(String id){
		Map<String , String> map = new HashMap<String, String>();
		boolean isc=IMService.idDuplicateCheck(id);
		map.put("isc", String.valueOf(isc));
		return map;
	}
	
	@RequestMapping(value = "/signUpMember.do" , method = RequestMethod.POST)
	public String signUpMember(MemberVO vo) {
		boolean isc=IMService.signUpMember(vo);
		return (isc)?"redirect:/login.do":"redirect:/signUp.do";
	}
	
}
