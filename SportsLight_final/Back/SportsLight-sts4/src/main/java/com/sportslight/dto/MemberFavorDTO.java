package com.sportslight.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class MemberFavorDTO {
	
	private int favorNum;
	private int memberNum;
	private int teamNum1;
	private int teamNum2;
	private int teamNum3;
	private int leagueNum1;
	private int leagueNum2;
	private int leagueNum3;
	
	private String teamName1;
	private String teamName2;
	private String teamName3;
	private String leagueName1;
    private String leagueName2;
    private String leagueName3;

}
