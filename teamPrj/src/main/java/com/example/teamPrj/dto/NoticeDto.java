package com.example.teamPrj.dto;

import java.time.LocalDate;
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
	LocalDate regidate;
	int mno;
	String id;
}
