package com.sportslight.view.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslight.dto.FavoriteDTO;
import com.sportslight.dto.HeartDTO;
import com.sportslight.dto.ViewBoardDTO;
import com.sportslight.dto.ViewDTO;
import com.sportslight.view.dao.ViewDAO;

@Service
public class ViewServiceImp implements ViewService{
	
	@Autowired
	private ViewDAO viewDAO;
	
	// 동영상 부분 -----------------------------------------

	// 동영상 정보 가져오기
	@Override
	public ViewDTO getVideoService(int videoNum) {
		// 정보를 가져올 때 마다 조회수가 증가
		viewDAO.viewCount(videoNum);
		// 동영상 정보를 리턴
		return viewDAO.getVideo(videoNum) ;
	}
	
	// 좋아요 즐겨찾기 부분 ----------------------------------
	
	// 좋아요 / 즐겨찾기 정보 가져오기
	
	// 좋아요
	@Override
	public HeartDTO getHeartService(int videoNum, int memberNum) {
		HeartDTO hdto = new HeartDTO();
		hdto.setMemberNum(memberNum);
		hdto.setVideoNum(videoNum);
		return viewDAO.getHeart(hdto);
	}
	
	// 즐겨찾기
	@Override
	public FavoriteDTO getFavoriteService(int videoNum, int memberNum) {
		FavoriteDTO fdto = new FavoriteDTO();
		fdto.setMemberNum(memberNum);
		fdto.setVideoNum(videoNum);
		return viewDAO.getFavorite(fdto);
	}
	
	// 좋아요 추가 / 해제
	@Override
	public void HeartService(HeartDTO hdto, boolean isHeartChecked) {
		if(!isHeartChecked) {
			viewDAO.insertHeart(hdto);
			System.out.println("좋아요 추가");
		}else {
			viewDAO.deleteHeart(hdto);
			System.out.println("좋아요 삭제");
		}
	}
	
	// 즐겨찾기 추가 / 해제
	@Override
	public void FavoriteService(FavoriteDTO fdto, boolean isFavoriteChecked) {
		if(!isFavoriteChecked) {
			viewDAO.insertFavorite(fdto);
			System.out.println("즐겨찾기 추가");
		}else {
			viewDAO.deleteFavorite(fdto);
			System.out.println("즐겨찾기 삭제");
		}
	}

	// 동영상 한줄 댓글 부분 ---------------------------------
	
	// 동영상 한줄 댓글 가져오기
	@Override
	public List<ViewBoardDTO> getVideoBoardService(int videoNum) {
		return viewDAO.getVideoBoard(videoNum);
	}

	// 동영상 한줄 댓글 쓰기
	@Override
	public String insertVideoBoardService(ViewBoardDTO vdto) {
		// 한줄 댓글 검사
		int chk = viewDAO.checkVideoBoard(vdto);
		if(chk < 1) {
			// 성공시 프로세스
			viewDAO.insertVideoBoard(vdto);
			return "success";
		}else {
			// 실패시 프로세스
			return "fail";
		}
	}

	// 동영상 한줄 댓글 수정
	@Override
	public void updateVideoBoardService(ViewBoardDTO vdto) {
		viewDAO.updateVideoBoard(vdto);
	}

	// 동영상 한줄 댓글 삭제
	@Override
	public void deleteVideoBoardService(ViewBoardDTO vdto) {
		viewDAO.deleteVideoBoard(vdto);
	}


}
