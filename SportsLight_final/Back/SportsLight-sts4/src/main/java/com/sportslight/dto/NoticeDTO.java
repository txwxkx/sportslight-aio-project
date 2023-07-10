package com.sportslight.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class NoticeDTO {
	
	private int noticeNum;
	private int adminNum;
	private String noticeTitle;
	private String noticeContent;
	private Date writeDate;

}
