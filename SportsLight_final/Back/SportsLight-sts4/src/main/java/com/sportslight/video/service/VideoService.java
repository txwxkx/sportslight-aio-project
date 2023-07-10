package com.sportslight.video.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportslight.dto.VideoDTO;


@Service
public interface VideoService {
	//메인페이지 영상 
	public List<VideoDTO> leagueListProcess();
	public List<VideoDTO> recommendListProcess();
	public List<VideoDTO> shortsListProcess();
	public List<VideoDTO> hitsListProcess();
	public List<VideoDTO> highlightListProcess();
	
	public boolean chkHeart(int memberNum);
	public int getLastHeart(int memberNum);
	public List<VideoDTO> getHeartRecommend(int []resp);
	//검색 
	public List<VideoDTO> searchProcess(String searchWord);
	
	//리그영상 
	public List<VideoDTO> premierListProcess();
	public List<VideoDTO> laligaListProcess();
	public List<VideoDTO> serieListProcess();
	public List<VideoDTO> championsListProcess();
	public List<VideoDTO> europaListProcess();
	public List<VideoDTO> league1ListProcess();
	public List<VideoDTO> kOneListProcess();
	public List<VideoDTO> kTwoListProcess();
	public List<VideoDTO> bundesligaListProcess();
	

}
