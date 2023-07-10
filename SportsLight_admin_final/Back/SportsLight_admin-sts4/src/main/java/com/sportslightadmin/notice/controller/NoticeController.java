package com.sportslightadmin.notice.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportslightadmin.notice.dto.NoticeDTO;
import com.sportslightadmin.notice.dto.NoticePageDTO;
import com.sportslightadmin.notice.service.NoticeService;

//모든 요청을 허용한다.
@CrossOrigin("*")

@RestController
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private NoticePageDTO pdto;

	private int currentPage;

	public NoticeController() {

	}

	// 리스트
	@GetMapping("/admin/notice/list/{currentPage}") // 페이지를 호출할 때,
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, NoticePageDTO pv) {
		Map<String, Object> map = new HashMap<>();

		int totalRecord = noticeService.countProcess();

		// 갯수가 한 개 이상이면 페이징 처리를 해줌
		if (totalRecord >= 1) {
			this.currentPage = currentPage; // currentPage에 1 할당

			this.pdto = new NoticePageDTO(this.currentPage, totalRecord);

			map.put("aList", noticeService.noticeListProcess(this.pdto));
			map.put("pv", this.pdto);

		}
		return map;
	}

	// 공지 글쓰기
	@PostMapping("/admin/notice/write")
	public String writeExcute(NoticeDTO dto) {
		noticeService.insertProcess(dto);
		return String.valueOf(1);
	}

	// 상세 페이지
	@GetMapping("/admin/notice/view/{noticeNum}")
	public NoticeDTO viewExecute(@PathVariable("noticeNum") int noticeNum) {
		return noticeService.contentProcess(noticeNum);
	}

	// 수정
	@PutMapping("/admin/notice/update")
	public void updateExecute(NoticeDTO dto, HttpServletRequest request){
		noticeService.updateProcess(dto);

	}
	  
	// 삭제
		@DeleteMapping("/admin/notice/delete/{noticeNum}")
		public void deleteExecute(@PathVariable("noticeNum") int noticeNum, HttpServletRequest request) {
			noticeService.deleteProcess(noticeNum);
		}
	 

}










