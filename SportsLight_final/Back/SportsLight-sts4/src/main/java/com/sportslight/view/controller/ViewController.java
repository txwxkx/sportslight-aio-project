package com.sportslight.view.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportslight.dto.FavoriteDTO;
import com.sportslight.dto.HeartDTO;
import com.sportslight.dto.ViewBoardDTO;
import com.sportslight.view.service.ViewService;

import lombok.NoArgsConstructor;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@NoArgsConstructor
public class ViewController {
	
	@Autowired
	private ViewService viewService;
	
	// 동영상 세부 페이지 호출
	@PostMapping("/view/{videoNum}")
	public Map<String, Object> viewExecute(@PathVariable("videoNum") int videoNum, int memberNum) {
		Map<String, Object> map = new HashMap<>();
		
		// 동영상 정보
		map.put("video", viewService.getVideoService(videoNum));
		
		// 좋아요 즐겨찾기 정보
		map.put("heart", viewService.getHeartService(videoNum, memberNum));
		map.put("favorite", viewService.getFavoriteService(videoNum, memberNum));
		
		// 한줄 댓글 정보
		map.put("videoBoard", viewService.getVideoBoardService(videoNum));

		// map으로 return
		System.out.println("동영상 정보 출력");
		return map;
	}
	
	// 좋아요 즐겨찾기 추가 / 수정
	@PostMapping("/view/heart")
	public void HeartChangeExecute(HeartDTO hdto, boolean isHeartChecked) {
		viewService.HeartService(hdto, isHeartChecked);
	}
	
	@PostMapping("/view/favorite")
	public void FavoriteChangeExecute(FavoriteDTO fdto, boolean isFavoriteChecked) {
		viewService.FavoriteService(fdto, isFavoriteChecked);
	}
	
	// 한줄 댓글 쓰기
	@PostMapping("/view/insertboard")
	public Map<String, Object> writeVideoBoardExecute(ViewBoardDTO vdto) {
		Map<String, Object> data = new HashMap<>();
		// 댓글 쓰기 프로세스
		String result = viewService.insertVideoBoardService(vdto);
		if(result == "success") {
			System.out.println("한줄 댓글 입력 완료");
			data.put("String", "댓글 입력 성공");
			return data;
		}else {
			System.out.println("오류 발생");
			data.put("String", "하나의 댓글만 입력 가능합니다.");
			return data;
		}
	}
	
	// 한줄 댓글 수정
	@PostMapping("/view/updateboard")
	public void updateVideoBoardExcute(ViewBoardDTO vdto) {
		System.out.println(vdto.getVideoBoardNum());
		viewService.updateVideoBoardService(vdto);
	}
	
	// 한글 댓글 삭제
	@PostMapping("/view/deleteboard")
	public void deleteVideoBoardExcute(ViewBoardDTO vdto) {
		viewService.deleteVideoBoardService(vdto);
		System.out.println("한줄 댓글 삭제 완료");
	}
	

}
