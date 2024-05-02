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
	private int num;
	private String title;
	private String content;
	private LocalDate regidate;
	private int mno;
	
}
