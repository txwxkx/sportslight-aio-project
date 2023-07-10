package com.sportslight.talk.service;

import java.util.List;

import com.sportslight.dto.TalkDTO;
import com.sportslight.dto.TalkPageDTO;

public interface TalkService {
	
	public int talkCountProcess();
	
	public List<TalkDTO> recentListProcess(TalkPageDTO talkpageDto);
	
	public List<TalkDTO> viewsListProcess(TalkPageDTO talkpageDto);
	
	public List<TalkDTO> leagueListProcess(int leagueNum);
	
	public void talkCreateProcess(TalkDTO talkDto);
	
	public TalkDTO talkReadProcess(int talkNum);
	
	public void talkUpdateProcess(TalkDTO talkDto, String urlpath);
	
	public void talkDeleteProcess(int talkNum, String urlpath);
	
	public String talkFileSelectprocess(int talkNum);
	
}//end class
