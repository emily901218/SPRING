package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.service.MemberService;
import com.java.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	HttpSession session;
	
	@Autowired
	MemberService memberService ;
	
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	
	@PostMapping("login")
	public String login(@RequestParam String id,@RequestParam String pw, Model model) {
		
			MemberVo memberVo = memberService.selectOne(id,pw);
		
		if(memberVo != null) {
			session.setAttribute("sessionId", memberVo.getId());
			session.setAttribute("sessionName", memberVo.getName());
		}
		
		return "index";
	}
}
