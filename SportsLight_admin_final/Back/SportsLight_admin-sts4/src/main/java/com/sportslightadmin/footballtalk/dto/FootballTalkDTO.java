package com.sportslightadmin.footballtalk.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyDTO;
import com.sportslightadmin.memberz.dto.MemberzDTO;

@Component
public class FootballTalkDTO {
	private int talkNum, memberNum, leagueNum, talkViews;
	private String talkTitle, talkContent, talkUpload;
	private Date regDate;
	
	private FootballTalkReplyDTO footballTalkReplyDTO;
	private MemberzDTO memberzDTO;
	
	public FootballTalkDTO() {
		
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

	public int getLeagueNum() {
		return leagueNum;
	}

	public void setLeagueNum(int leagueNum) {
		this.leagueNum = leagueNum;
	}

	public int getTalkViews() {
		return talkViews;
	}

	public void setTalkViews(int talkViews) {
		this.talkViews = talkViews;
	}

	public String getTalkTitle() {
		return talkTitle;
	}

	public void setTalkTitle(String talkTitle) {
		this.talkTitle = talkTitle;
	}

	public String getTalkContent() {
		return talkContent;
	}

	public void setTalkContent(String talkContent) {
		this.talkContent = talkContent;
	}

	public String getTalkUpload() {
		return talkUpload;
	}

	public void setTalkUpload(String talkUpload) {
		this.talkUpload = talkUpload;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public FootballTalkReplyDTO getFootballTalkReplyDTO() {
		return footballTalkReplyDTO;
	}

	public void setFootballTalkReplyDTO(FootballTalkReplyDTO footballTalkReplyDTO) {
		this.footballTalkReplyDTO = footballTalkReplyDTO;
	}

	public MemberzDTO getMemberzDTO() {
		return memberzDTO;
	}

	public void setMemberzDTO(MemberzDTO memberzDTO) {
		this.memberzDTO = memberzDTO;
	}
	
	
	
	

}
