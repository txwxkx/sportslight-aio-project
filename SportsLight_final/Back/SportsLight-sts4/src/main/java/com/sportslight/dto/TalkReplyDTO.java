package com.sportslight.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@NoArgsConstructor
public class TalkReplyDTO {
	
	private int talkReplyNum; //댓글 고유번호
	
	private int talkNum; //게시물 고유번호
	
	private int memberNum; //회원 고유번호
	
	private String talkReplyContent; //댓글 내용
	
	private Date regDate; //작성 일자
	
	private MembersDTO membersDto;
	
}//end class
