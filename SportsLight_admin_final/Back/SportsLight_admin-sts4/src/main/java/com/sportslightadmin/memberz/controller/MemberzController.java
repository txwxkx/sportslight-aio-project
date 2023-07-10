package com.sportslightadmin.memberz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportslightadmin.memberz.dto.MemberzDTO;
import com.sportslightadmin.memberz.dto.MemberzPageDTO;
import com.sportslightadmin.memberz.service.MemberzService;

//모든 요청 허용
@CrossOrigin("*")

@RestController
public class MemberzController {
	
	@Autowired
	private MemberzService memberzService;
	
	@Autowired
	private MemberzPageDTO pdto;
	
	private int currentPage;
	
	public MemberzController() {
		
	}
	
	// 회원 정보 리스트
	@GetMapping("/admin/member/list/{currentPage}")
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, MemberzPageDTO pv) {
		Map<String, Object> map = new HashMap<>();

		int totalRecord = memberzService.countProcess();

		// 갯수가 한 개 이상이면 페이징 처리를 해줌
		if (totalRecord >= 1) {
			this.currentPage = currentPage; // currentPage에 1 할당

			this.pdto = new MemberzPageDTO(this.currentPage, totalRecord);

			map.put("aList", memberzService.memberzListProcess(this.pdto));
			map.put("pv", this.pdto);

		}
		return map;
	}
	
	
	
	// 회원 탈퇴 (정보 수정)
	@PostMapping("/admin/member/list/update/{memberNum}")
	public void updateMemberLeave(@PathVariable("memberNum") int memberNum) {
	    memberzService.memberLeaveProcess(memberNum);
	}

}
















