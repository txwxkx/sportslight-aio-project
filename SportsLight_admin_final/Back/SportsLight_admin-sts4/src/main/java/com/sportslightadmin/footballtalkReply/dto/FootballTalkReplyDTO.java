package com.sportslightadmin.footballtalkReply.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.sportslightadmin.memberz.dto.MemberzDTO;

@Component
public class FootballTalkReplyDTO {
	private int talkReplyNum, talkNum, memberNum;
	private String talkReplyContent;
	private Date regDate;
	private MemberzDTO memberzDTO;
	
	
	public FootballTalkReplyDTO() {
		
	}
	
	public int getTalkReplyNum() {
		return talkReplyNum;
	}
	public void setTalkReplyNum(int talkReplyNum) {
		this.talkReplyNum = talkReplyNum;
	}
	public int getTalkNum() {
		return talkNum;
	}
	public void setTalkNum(int talkNum) {
		this.talkNum = talkNum;
	}
	
	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getTalkReplyContent() {
		return talkReplyContent;
	}
	public void setTalkReplyContent(String talkReplyContent) {
		this.talkReplyContent = talkReplyContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public MemberzDTO getMemberzDTO() {
		return memberzDTO;
	}

	public void setMemberzDTO(MemberzDTO memberzDTO) {
		this.memberzDTO = memberzDTO;
	}
	
	

}
