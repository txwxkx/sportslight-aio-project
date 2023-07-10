package com.sportslight.mymy.service;

import java.util.List;
import java.util.Map;

import com.sportslight.dto.FavoriteDTO;
import com.sportslight.dto.HeartDTO;
import com.sportslight.dto.MemberFavorDTO;
import com.sportslight.dto.NoticeDTO;


public interface MymyService {
	
	// 선호 설정 부분 ---------------------------------------
	
	// 팀 / 리그 정보 가져오기
	public Map<String, Object> getFavorService(int memberNum);
	
	// 선호 팀 / 리그 수정
	public String updateFavorTeamService(MemberFavorDTO mfDTO);
	
	// 좋아요/즐겨찾기 부분 ----------------------------------
	
	// 좋아요 동영상 가져오기
	public List<HeartDTO> getHeartVideoService(int memberNum);
	
	// 즐겨찾기 동영상 가져오기
	public List<FavoriteDTO> getFavoriteVideoService(int memberNum);
	
	// 공지사항 부분 ----------------------------------------
	
	// 공지사항 리스트 가져오기
	public List<NoticeDTO> getNoticeListService();
	
	// 공지사항 세부 보기
	public NoticeDTO getNoticeViewService(int noticeNum);
	
}
