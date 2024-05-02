package com.example.teamPrj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamPrj.dao.INoticeDao;

public class MyController_2 {
	
	@Autowired
	private INoticeDao noticeDao;
	
	@RequestMapping("/writeForm")
	public void writeForm() {
		
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam("title") String title, @RequestParam("content") String content) {
		String id2 = "aaa";
		Date regidate = new Date();
		noticeDao.writeDao(title, content, regidate, id2);
		
		return "redirect:detail";
	}
	
}
