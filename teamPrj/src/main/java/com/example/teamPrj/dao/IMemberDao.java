package com.example.teamPrj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.teamPrj.dto.MemberDto;
import com.example.teamPrj.dto.NoticeDto;

@Mapper
public interface IMemberDao {
	//로그인할때, 자기 게시글 불러올때 쓰는 DAO
	
	public List<MemberDto> loginDao(String id);
	
	public List<NoticeDto> getMyList(int mno);
	
	public void regist(@Param("id") String id, @Param("pw") String pw, @Param("name") String name,@Param("email") String email,@Param("tel") String tel);
}
