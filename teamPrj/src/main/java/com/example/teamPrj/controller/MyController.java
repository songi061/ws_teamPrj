package com.example.teamPrj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamPrj.dao.IMemberDao;
import com.example.teamPrj.dao.INoticeDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private INoticeDao noticeDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "hello";
	}
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request, @RequestParam String id, @RequestParam String pw) {
		HttpSession session = request.getSession();

		
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("regidate") Date regidate ) {
		String id2 = "aaa";
		noticeDao.writeDao(title, content, regidate, id2);
		
		return "redirect:detail";
	}
	
	
}
