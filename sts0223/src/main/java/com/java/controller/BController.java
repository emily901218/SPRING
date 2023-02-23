package com.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.service.BoardService;

@Controller
public class BController {

	@Autowired
	BoardService boardService;
	
	
	@GetMapping("board/notice_list")
	public String notice_list(@RequestParam(defaultValue = "1") int page, Model model) {
		
		Map<String,Object> map = boardService.selectBoardList(page);
		model.addAttribute("map",map);
		
		
		return "board/notice_list";
	}
	
}
