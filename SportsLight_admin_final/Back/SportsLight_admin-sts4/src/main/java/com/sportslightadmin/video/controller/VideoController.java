package com.sportslightadmin.video.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportslightadmin.video.dto.VideoDTO;
import com.sportslightadmin.video.dto.VideoPageDTO;
import com.sportslightadmin.video.service.VideoService;

// 모든 요청 허용
@CrossOrigin("*")

@RestController
public class VideoController {

	@Autowired
	private VideoService videoService;

	@Autowired
	private VideoPageDTO pdto;

	private int currentPage;

	public VideoController() {

	}

	// 리스트
	@GetMapping("/admin/video/list/{currentPage}")
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, VideoPageDTO pv) {
		Map<String, Object> map = new HashMap<>();
		

		int totalRecord = videoService.countProcess();

		// 갯수가 한 개 이상이면 페이징 처리를 해줌
		if (totalRecord >= 1) {
			this.currentPage = currentPage; // currentPage에 1 할당

			this.pdto = new VideoPageDTO(this.currentPage, totalRecord);

			map.put("aList", videoService.videoListProcess(this.pdto));
			map.put("pv", this.pdto);

		}
		return map;

	}

	// 비디오 상세페이지
	@GetMapping("/admin/video/view/{videoNum}")
	public VideoDTO viewExecute(@PathVariable("videoNum") int videoNum) {
		return videoService.videoContentProcess(videoNum);
	}

	// 수정
	@PutMapping("/admin/video/update")
	public void updateExecute(VideoDTO dto, HttpServletRequest request) {
		videoService.updateProcess(dto);

	}

	// 삭제
	@DeleteMapping("/admin/video/delete/{videoNum}")
	public void deleteExecute(@PathVariable("videoNum") int videoNum, HttpServletRequest request) {
		videoService.deleteProcess(videoNum);
	}

}









