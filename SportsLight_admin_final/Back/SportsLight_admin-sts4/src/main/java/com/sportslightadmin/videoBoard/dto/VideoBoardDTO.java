package com.sportslightadmin.videoBoard.dto;

import org.springframework.stereotype.Component;

import com.sportslightadmin.memberz.dto.MemberzDTO;
import com.sportslightadmin.video.dto.VideoPageDTO;

@Component
public class VideoBoardDTO {
	private int videoBoardNum; // 한줄 게시판 고유번호
	private int videoNum; //비디오 고유 번호
	private int memberNum; 
	private String videoReply; // 한줄 게시판 내용
	private MemberzDTO memberzDTO;

	
	public VideoBoardDTO() {
		
	}

	public int getVideoBoardNum() {
		return videoBoardNum;
	}

	public void setVideoBoardNum(int videoBoardNum) {
		this.videoBoardNum = videoBoardNum;
	}

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getVideoReply() {
		return videoReply;
	}

	public void setVideoReply(String videoReply) {
		this.videoReply = videoReply;
	}

	public MemberzDTO getMemberzDTO() {
		return memberzDTO;
	}

	public void setMemberzDTO(MemberzDTO memberzDTO) {
		this.memberzDTO = memberzDTO;
	}
	
	

}
