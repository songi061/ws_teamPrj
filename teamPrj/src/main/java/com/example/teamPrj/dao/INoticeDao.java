package com.example.teamPrj.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.teamPrj.dto.MemberDto;
import com.example.teamPrj.dto.NoticeDto;

@Mapper
public interface INoticeDao {
	//게시글 목록 불러오기, 게시글 상세목록 불러오기, 게시글 쓰기 , 나에게 쓴 게시물 불러오기
	
	public int writeDao(@Param("title")String title,@Param("content")String content,@Param("regidate")LocalDate regidate,
	@Param("mno")int mno);
	
	public NoticeDto getDetailList(int num);
	
	public List<NoticeDto> getList();
	
	public List<NoticeDto> getSecretList(String id);
	
}
