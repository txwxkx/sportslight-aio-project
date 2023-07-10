package com.sportslight.talk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslight.dto.TalkDTO;
import com.sportslight.dto.TalkPageDTO;

@Mapper
@Repository
public interface TalkDAO {
	
	public int talkCount();
	
	public List<TalkDTO> recentList(TalkPageDTO talkpageDto);
	
	public List<TalkDTO> viewsList(TalkPageDTO talkpageDto);
	
	public List<TalkDTO> leagueList(int leagueNum);
	
	public void talkCreate(TalkDTO talkDto);
	
	public TalkDTO talkRead(int talkNum);
	
	public void talkUpdate(TalkDTO talkDto);
	
	public void talkDelete(int talkNum);
	
	public String talkUpload(int talkNum);
	
	public void talkViews(int talkNum);
	
}//end class
