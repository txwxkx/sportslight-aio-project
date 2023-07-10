package com.sportslight.dto;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class HeartDTO {
	
	private int heartNum;
	private int memberNum;
	private int videoNum;
	private String videoName;
	private String thumbnailUrl;
}
