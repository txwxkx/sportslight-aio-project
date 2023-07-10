package com.sportslight.talkreply.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportslight.dto.TalkReplyDTO;
import com.sportslight.talkreply.service.TalkReplyService;

import lombok.NoArgsConstructor;


//http://localhost:8090/footballreply/list/1

@RestController
@NoArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class TalkReplyController {
	
	@Autowired
	private TalkReplyService talkreplyService;

	
	//게시물 리스트
	@GetMapping("/footballreply/list/{talkNum}")
	public Map<String, Object> getReplyListExecute(@PathVariable("talkNum") int talkNum) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("listCount", talkreplyService.replyCountProcess());
		
		map.put("replyList", talkreplyService.replyListProcess(talkNum));
			
		return map;
	}//end getListExecute()
	

	//게시물 작성
	@PostMapping("/footballreply/create")
	public String createExecute(@RequestBody TalkReplyDTO dto) {

		//System.out.println(dto.getMembersDTO().getMemberProfile());
		
//		dto.setIp(req.getRemoteAddr());
		
//		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//		dto.setMemberNum(authInfo.getMemberNum());
		System.out.println("댓글 내용 : "+dto.getTalkReplyContent());
		talkreplyService.replyCreateProcess(dto);
		
		
		return "redirect:/footballreply/list";
	}//end createExecute
	
	
	//게시물 수정
	@PutMapping("/footballreply/update")
	public void updateExecute(TalkReplyDTO dto) throws IllegalStateException, IOException {
		talkreplyService.replyUpdateProcess(dto);
	}//end updateExecute
	
	
	//게시물 삭제
	@DeleteMapping("/footballreply/delete/{talkreplyNum}")
	public void deleteExecute(@PathVariable("talkreplyNum") int talkreplyNum) {
		talkreplyService.replyDeleteProcess(talkreplyNum);
	}//end deleteExecute

}//end class
