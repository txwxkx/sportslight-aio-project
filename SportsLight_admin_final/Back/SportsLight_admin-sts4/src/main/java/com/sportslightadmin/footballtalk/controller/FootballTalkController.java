package com.sportslightadmin.footballtalk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sportslightadmin.footballtalk.dto.FootballTalkPageDTO;
import com.sportslightadmin.footballtalk.service.FootballTalkService;

//모든 요청 허용
@CrossOrigin("*")

@RestController
public class FootballTalkController {
	
	@Autowired
	private FootballTalkService footballTalkService;
	
	@Autowired
	private FootballTalkPageDTO pdto;
	
	private int currentPage;
	
	public FootballTalkController() {
		
	}
	
	@GetMapping("/admin/footballTalk/list/{currentPage}")
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, FootballTalkPageDTO pv) {
		Map<String, Object> map = new HashMap<>();

		int totalRecord = footballTalkService.countProcess();
		

		// 갯수가 한 개 이상이면 페이징 처리를 해줌
		if (totalRecord >= 1) {
			this.currentPage = currentPage; // currentPage에 1 할당

			this.pdto = new FootballTalkPageDTO(this.currentPage, totalRecord);

			map.put("aList", footballTalkService.footballTalkListProcess(this.pdto));
			map.put("pv", this.pdto);

		}
		return map;

	}
	
	// 삭제
		@DeleteMapping("/admin/footballTalk/delete/{talkNum}")
		public void deleteExecute(@PathVariable("talkNum") int talkNum, HttpServletRequest request) {
			footballTalkService.deleteProcess(talkNum);
		}

}





















