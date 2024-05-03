package com.example.teamPrj.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamPrj.dao.IMemberDao;
import com.example.teamPrj.dao.INoticeDao;
import com.example.teamPrj.dto.MemberDto;
import com.example.teamPrj.dto.NoticeDto;

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
	public String root() {
		return "login";
	}
	
	@RequestMapping("/login")
	public void login() {
		log.info("로그인 페이지 가기.....");
	}
	
	@RequestMapping("/loginDo")
	public String loginDo(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("pw") String pw) {
		HttpSession session = request.getSession();
		
		List<MemberDto> member = memberDao.loginDao(id);
		String memberId = member.get(0).getId();
		String memberPw = member.get(0).getPw();
		if(memberId.equals(id) && memberPw.equals(pw)) {
			session.setAttribute("member",member);
			session.setAttribute("id",id);
			session.setAttribute("name",member.get(0).getName());
			session.setAttribute("mno", member.get(0).getMno());
	        return "main";
		}else {
			System.out.println("로그인 실패");
			return "login";
		}
		
	}

	
	
	@RequestMapping("/myPage")
	public void myPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<MemberDto> member = (List<MemberDto>)session.getAttribute("member");
		//멤버 정보 불러오기
		model.addAttribute("member",member);
		
		//작성 글 불러오기
		List<NoticeDto> myList = memberDao.getMyList(member.get(0).getMno());
		model.addAttribute("myList",myList);
		
		//비밀 글 불러오기
		String id = (String)session.getAttribute("id");
		List<NoticeDto> secretList = noticeDao.getSecretList(id);
		model.addAttribute("secretList",secretList);
	}
	
	
	@RequestMapping("/noticeList")
	public void list(Model model) {
		List<NoticeDto> list = noticeDao.getList();
		model.addAttribute("list",list);
	}
	
	
	

	@RequestMapping("/writeForm")
	public void writeForm() {
		
	}

	//write
	@RequestMapping("/write")
	public String write(@RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("content") String content,HttpSession session) {
		
		int mno = (int) session.getAttribute("mno");
		//Date regidate = new Date();
		LocalDate regidate = LocalDate.now();
		
		noticeDao.writeDao(title, content, regidate, mno, id);
		
		return "redirect:noticeList";
	}
	
	//detail
	@RequestMapping("/detail")
	public String getDetailList(@RequestParam("num") String num, Model model) {
		int num_=Integer.parseInt(num);
		model.addAttribute("dto", noticeDao.getDetailList(num_));
		return "detail";
	}

	
}
