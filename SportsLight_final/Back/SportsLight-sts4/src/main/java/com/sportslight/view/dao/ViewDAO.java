package com.sportslight.view.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslight.dto.FavoriteDTO;
import com.sportslight.dto.HeartDTO;
import com.sportslight.dto.ViewBoardDTO;
import com.sportslight.dto.ViewDTO;

@Mapper
@Repository
public interface ViewDAO {
	
	// 동영상 부분 -----------------------------------------
	
	// 동영상 정보 가져오기
	public ViewDTO getVideo(int videoNum);
	
	// 동영상 조회시 조회수 1씩 증가
	public void viewCount(int videoNum);
	
	// 좋아요 / 즐겨찾기 정보 가져오기
	public HeartDTO getHeart(HeartDTO hdto);
	public FavoriteDTO getFavorite(FavoriteDTO fdto);
	
	// 좋아요 추가 / 해제
	public void insertHeart(HeartDTO hdto);
	public void deleteHeart(HeartDTO hdto);
	
	// 즐겨찾기 추가 / 해제
	public void insertFavorite(FavoriteDTO fdto);
	public void deleteFavorite(FavoriteDTO fdto);
	
	// 동영상 한줄 댓글 부분 ---------------------------------
	
	// 동영상 한줄 댓글 가져오기
	public List<ViewBoardDTO> getVideoBoard(int videoNum);
	
	// 동영상 한줄 댓글 중복 검사
	public int checkVideoBoard(ViewBoardDTO vdto);
	
	// 동영상 한줄 댓글 쓰기
	public void insertVideoBoard(ViewBoardDTO vdto);
	
	// 동영상 한줄 댓글 수정
	public void updateVideoBoard(ViewBoardDTO vdto);
	
	// 동영상 한줄 댓글 삭제
	public void deleteVideoBoard(ViewBoardDTO vdto);

}
