package com.example.teamPrj.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface INoticeDao {
	//게시글 목록 불러오기, 게시글 상세목록 불러오기, 게시글 쓰기
	public String writeDao(@Param("title")String title,
	@Param("content")String content,
	@Param("regidate")Date regidate,
	@Param("id")String id);
}
