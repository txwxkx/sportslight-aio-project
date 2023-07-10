package com.sportslight.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class LeagueDTO {
	
	private int leagueNum;
	private String leagueName;

}
