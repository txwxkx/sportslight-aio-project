package com.sportslightadmin.footballtalkReply.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyPageDTO;
import com.sportslightadmin.footballtalkReply.service.FootballtalkReplyService;

//모든 요청 허용
@CrossOrigin("*")

@RestController
public class FootballTalkReplyController {
	
	@Autowired
	private FootballtalkReplyService footballtalkReplyService;
	
	@Autowired
	private FootballTalkReplyPageDTO pdto;
	
	private int currentPage;
	
	public FootballTalkReplyController() {
		
	}
	
	@GetMapping("/admin/footballTalkReply/list/{talkNum}/{currentPage}")
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, 
			@PathVariable("talkNum") int talkNum, FootballTalkReplyPageDTO pv) {
		
		Map<String, Object> map = new HashMap<>();
		
		int totalRecord = footballtalkReplyService.countProcess(talkNum);
		
		
		if (totalRecord >= 1) {
			this.currentPage = currentPage; // currentPage에 1 할당

			this.pdto = new FootballTalkReplyPageDTO(this.currentPage, talkNum);
			pdto.setTalkNum(talkNum); // talkNum 값을 저장함

			map.put("aList", footballtalkReplyService.footballTalkReplyListProcess(this.pdto));
			map.put("pv", this.pdto);

		}
		return map;
		
		
	}
	
	// 삭제
	@DeleteMapping("admin/footballTalkReply/list/delete/{talkReplyNum}")
	public void deleteExecute(@PathVariable("talkReplyNum") int talkReplyNum, HttpServletRequest request) {
		footballtalkReplyService.deleteProcess(talkReplyNum);
	}
	

}





















