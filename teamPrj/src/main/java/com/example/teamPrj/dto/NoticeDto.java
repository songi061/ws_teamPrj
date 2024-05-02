package com.example.teamPrj.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {
	int num;
	String title;
	String content;
	Date regidate;
	int mno;
}
