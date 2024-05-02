package com.example.teamPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamPrj.dao.IMemberDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	private IMemberDao memberDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "hello";
	}
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request, @RequestParam String id, @RequestParam String pw) {
		HttpSession session = request.getSession();

		
	}
	
	
	
}
