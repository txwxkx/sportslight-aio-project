package com.sportslight.dto;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@NoArgsConstructor
public class TalkDTO {
	
	private int talkNum; //게시물 고유번호
	
	private int leagueNum; //리그 고유번호
	
	private int memberNum; //회원 고유번호
	
	private String talkTitle; //게시물 제목
	
	private String talkContent; //게시물 내용
	
	private String talkUpload; //테이블의 파일 첨부를 처리해주는 멤버 변수
	
	private MultipartFile filename; //form 페이지에서 파일 첨부를 받아 처리해주는 멤버 변수
	
	private Date regDate; //작성 일자
	
	private int talkViews; //조회수
	
	private LeagueDTO leagueDto;
	
	private MembersDTO membersDto;
	
}//end class
