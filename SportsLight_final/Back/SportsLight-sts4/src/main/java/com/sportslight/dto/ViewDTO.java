package com.sportslight.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ViewDTO {
	
	private int videoNum;
	private String videoName;
	private String thumbnailUrl;
	private String videoUrl;
	private int videoviews;
	private char videotype;
	private int teamNum1;
	private int teamNum2;
	private int leagueNum;
	private int seasonNum;
	

}
