package com.sportslight.video.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sportslight.dto.VideoDTO;
import com.sportslight.mymy.dao.MymyDAO;
import com.sportslight.mymy.service.MymyService;
import com.sportslight.video.service.VideoService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class VideoController {

	@Autowired
	private VideoService videoService;

	public VideoController() {

	}

	//main 페이지 영상 리스트 
	@PostMapping("/main")
	public Map<String, Object> videoList(@RequestBody int memberNum) {
		Map<String, Object> map = new HashMap<>();
		System.out.println(memberNum);
		List<VideoDTO> leagueList = videoService.leagueListProcess();
		List<VideoDTO> shortsList = videoService.shortsListProcess();
		List<VideoDTO> hitsList = videoService.hitsListProcess();
		List<VideoDTO> highlightList = videoService.highlightListProcess();
		
		boolean chk = videoService.chkHeart(memberNum);
		System.out.println(chk);
		if(chk) {
			
			int selectNum = videoService.getLastHeart(memberNum);
			System.out.println(chk);
			System.out.println("요청 시작");
			RestTemplate restTemplate = new RestTemplate();

	        // GET 요청 보내기
	        String url = "http://localhost:5000/" + selectNum;
	        ResponseEntity<int[]> response = restTemplate.exchange(url, HttpMethod.GET, null, int[].class);

	        // 응답 확인
	        int statusCode = response.getStatusCodeValue();
	        int[] responseBody = response.getBody();

	        System.out.println("Status code: " + statusCode);
	        System.out.println("Response body: ");
	        for (int num : responseBody) {
	            System.out.println(num);
	        }
	        
	        // 가져온 정보로 비디오 정보 가져오기
	        List<VideoDTO> recommendList = videoService.getHeartRecommend(responseBody);
	        map.put("recommendList", recommendList);
	        
		}else {
			List<VideoDTO> recommendList = videoService.recommendListProcess();
			map.put("recommendList", recommendList);
		}
		
		map.put("leagueList", leagueList);
		map.put("shortsList", shortsList);
		map.put("hitsList", hitsList);
		map.put("highlightList", highlightList);
		

		return map;
	}
	
	
	//search 페이지 영상 리스트 
	@GetMapping("/search/{searchWord}")
	public Map<String, Object> getSearchVideos(@PathVariable("searchWord") String searchWord) {
	    Map<String, Object> map = new HashMap<>();

	    List<VideoDTO> searchList = videoService.searchProcess(searchWord);

	    map.put("searchList", searchList);

	    return map;
	}
	
	//leagueVideo 페이지 영상 리스트
	@GetMapping("/category")
	public Map<String, Object> leagueVideoList() {
		Map<String, Object> map = new HashMap<>();
		
		List<VideoDTO> premierList = videoService.premierListProcess();
		List<VideoDTO> laligaList = videoService.laligaListProcess();
		List<VideoDTO> serieList = videoService.serieListProcess();
		List<VideoDTO> championsList = videoService.championsListProcess();
		List<VideoDTO> bundesligaList = videoService.bundesligaListProcess();
		List<VideoDTO> europaList = videoService.europaListProcess();
		List<VideoDTO> league1List = videoService.league1ListProcess();
		List<VideoDTO> kOneList = videoService.kOneListProcess();
		List<VideoDTO> kTwoList = videoService.kTwoListProcess();
		
		map.put("premierList", premierList);
		map.put("laligaList", laligaList);
		map.put("serieList", serieList);
		map.put("championsList", championsList);
		map.put("bundesligaList", bundesligaList);
		map.put("europaList", europaList);
		map.put("league1List", league1List);
		map.put("kOneList", kOneList);
		map.put("kTwoList", kTwoList);
		
		return map;
	}
	

}// main controller()







