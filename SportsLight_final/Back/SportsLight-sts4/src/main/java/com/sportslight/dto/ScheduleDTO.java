package com.sportslight.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
	
	private int scheduleNum; //일정 고유번호
	
	private String leagueName; //리그 이름
	
	private String leagueYM; //리그 연월
	
	private Date matchDate; //경기 날짜
	
	private String matchTime; //경기 시간
	
	private String matchPlace; //경기 장소
	
	private String teamAName; //A 팀 이름
	
	private Integer teamAPoint; //A 팀 점수
	
	private Integer teamBPoint; //B 팀 점수
	
	private String teamBName; //B 팀 이름
	
	private String matchContent; //경기 내용
	
}//end class
