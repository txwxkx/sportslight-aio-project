package com.sportslightadmin.notice.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.sportslightadmin.adminz.dto.AdminzDTO;

@Component
public class NoticeDTO {
	private int noticeNum, adminNum;
	private String noticeTitle, noticeContent;
	private Date writeDate;
	private AdminzDTO adminzDTO; 
	
	public NoticeDTO() {
		
	}
	
	public int getAdminNum() {
		return adminNum;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public AdminzDTO getAdminzDTO() {
		return adminzDTO;
	}

	public void setAdminzDTO(AdminzDTO adminzDTO) {
		this.adminzDTO = adminzDTO;
	}
	
	
	

}
