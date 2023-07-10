package com.sportslight.view.service;

import java.util.List;

import com.sportslight.dto.FavoriteDTO;
import com.sportslight.dto.HeartDTO;
import com.sportslight.dto.ViewBoardDTO;
import com.sportslight.dto.ViewDTO;

public interface ViewService {

	// 동영상 부분 -----------------------------------------
	
	// 동영상 정보 가져오기
	public ViewDTO getVideoService(int videoNum);
	
//	// 좋아요 / 즐겨찾기 정보 가져오기
	public HeartDTO getHeartService(int videoNum, int memberNum);
	public FavoriteDTO getFavoriteService(int videoNum, int memberNum);
//	
//	// 좋아요 추가 / 해제
//	public void insertHeartService(HeartDTO hdto);
//	public void deleteHeartService(int heartNum);
	public void HeartService(HeartDTO hdto, boolean isHeartChecked);
//	
//	// 즐겨찾기 추가 / 해제
//	public void insertFavoriteService(FavoriteDTO fdto);
//	public void deleteFavoriteService(int favoriteNum);
	public void FavoriteService(FavoriteDTO fdto, boolean isFavoriteChecked);
	
	// 동영상 한줄 댓글 부분 ---------------------------------
	
	// 동영상 한줄 댓글 가져오기
	public List<ViewBoardDTO> getVideoBoardService(int videoNum);
	
	// 동영상 한줄 댓글 쓰기
	public String insertVideoBoardService(ViewBoardDTO vdto);
		
	// 동영상 한줄 댓글 수정
	public void updateVideoBoardService(ViewBoardDTO vdto);
		
	// 동영상 한줄 댓글 삭제
	public void deleteVideoBoardService(ViewBoardDTO vdto);
	
	
}
