package com.sportslight.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class ViewBoardDTO {

	private int videoBoardNum;
	private int videoNum;
	private int memberNum;
	private String videoReply;
	private String memberProfile;
}
