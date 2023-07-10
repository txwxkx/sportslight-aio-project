package com.sportslight.video.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslight.dto.VideoDTO;

@Mapper
@Repository
public interface VideoDAO {
	
	List<VideoDTO> leagueList();
	List<VideoDTO> recommendList();
	List<VideoDTO> shortsList();
	List<VideoDTO> hitsList();
	List<VideoDTO> highlightList();
	
	//검색 
	List<VideoDTO> searchList(String searchWord);
	
	//리그영상 
	List<VideoDTO> premierList();
	List<VideoDTO> laligaList();
	List<VideoDTO> serieList();
	List<VideoDTO> championsList();
	List<VideoDTO> bundesligaList();
	List<VideoDTO> europaList();
	List<VideoDTO> league1List();
	List<VideoDTO> kOneList();
	List<VideoDTO> kTwoList();
	

}
