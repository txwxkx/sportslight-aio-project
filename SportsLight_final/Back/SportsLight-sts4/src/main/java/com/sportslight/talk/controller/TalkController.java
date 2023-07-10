package com.sportslight.talk.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sportslight.common.file.FileUpload;
import com.sportslight.dto.TalkDTO;
import com.sportslight.dto.TalkPageDTO;
import com.sportslight.talk.service.TalkService;

import lombok.NoArgsConstructor;


//http://localhost:8090/footballtalk/list/1

@RestController
@NoArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class TalkController {
	
	@Autowired
	private TalkService talkService;
	
	@Value("${spring.servlet.multipart.location}")
	private String filePath;
	
	@Autowired
	private TalkPageDTO talkpageDto;

	private int currentPage;
	
	
	//게시물 리스트
	@GetMapping("/footballtalk/talklist/{currentPage}")
	public Map<String, Object> talkListExecute(@PathVariable("currentPage") int currentPage) {
		Map<String, Object> map = new HashMap<>();
		int totalRecord = talkService.talkCountProcess();
		if(totalRecord >= 1) {
//			if(pdto.getCurrentPage() == 0)
//				this.currentPage = 1;
				this.currentPage = currentPage; 
//			else
//				this.currentPage = pdto.getCurrentPage();
			
			this.talkpageDto = new TalkPageDTO(this.currentPage, totalRecord);
			
			map.put("recentList", talkService.recentListProcess(this.talkpageDto));
			
			map.put("viewsList", talkService.viewsListProcess(this.talkpageDto));
			
			map.put("talkpageDto", this.talkpageDto);
		}
		return map;
	}//end talkListExecute()
	
	
	//게시물 리스트
		@GetMapping("/footballtalk/leaguelist/{leagueNum}")
		public Map<String, Object> leagueListExecute(@PathVariable("leagueNum") int leagueNum) {
			Map<String, Object> map = new HashMap<>();
				
			map.put("leagueList", talkService.leagueListProcess(leagueNum));
			
			return map;
		}//end leagueListExecute()
	

	//게시물 작성
	@PostMapping("/footballtalk/create")
	public String talkCreateExecute(TalkDTO dto) {
		MultipartFile file = dto.getFilename();
		
		//System.out.println(dto.getMembersDTO().getMemberProfile());
		
		//파일 첨부가 있으면...
		if(file!=null && !file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, filePath);
			dto.setTalkUpload(random + "_" + file.getOriginalFilename());
		}
		
//		dto.setIp(req.getRemoteAddr());
		
//		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//		dto.setMemberNum(authInfo.getMemberNum());
		
		talkService.talkCreateProcess(dto);
		
		return "redirect:/footballtalk/list";
	}//end createExecute
	
	
	//게시물 조회
	@GetMapping("/footballtalk/read/{talkNum}")
	public TalkDTO talkReadExecute(@PathVariable("talkNum") int talkNum) {
		return talkService.talkReadProcess(talkNum);
	}//end readExecute
	
	
	//게시물 수정
	@PutMapping("/footballtalk/update")
	public void talkUpdateExecute(TalkDTO dto) throws IllegalStateException, IOException {
		MultipartFile file = dto.getFilename();
		if(file!=null && !file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, filePath);
			dto.setTalkUpload(random + "_" + file.getOriginalFilename());
			//d:\\download\\temp 경로에 첨부파일 저장
			file.transferTo(new File(random + "_" + file.getOriginalFilename()));
		}
		talkService.talkUpdateProcess(dto, filePath);
	}//end updateExecute
	
	
	//게시물 삭제
	@DeleteMapping("/footballtalk/delete/{talkNum}")
	public void talkDeleteExecute(@PathVariable("talkNum") int talkNum) {
		talkService.talkDeleteProcess(talkNum, filePath);
	}//end deleteExecute
	
	
	//게시물 첨부파일 다운로드
	@GetMapping("/footballtalk/download/{filename}")
	public ResponseEntity<Resource> talkDownloadExecute(@PathVariable("filename") String filename) throws IOException {
		String fileName = filename.substring(filename.indexOf("_") + 1); 
		//파일명이 한글일 때 인코딩 작업을 한다.
		String str = URLEncoder.encode(filename, "UTF-8");
		//원본파일명에서 공백이 있을 때, +로 표시가 되므로 공백으로 처리해줌.
		str = str.replaceAll("\\+", "%20");
		Path path = Paths.get(filePath + "\\" + filename);
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		System.out.println("resource:" + resource.getFilename());
		
		return ResponseEntity.ok()
		   .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
		   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + str + ";")
		   .body(resource);
	}//end downloadExecute

}//end class
