package com.sportslightadmin.video.service;

import java.util.List;

import com.sportslightadmin.video.dto.VideoDTO;
import com.sportslightadmin.video.dto.VideoPageDTO;

public interface VideoService {
	public int countProcess();
	public List<VideoDTO> videoListProcess(VideoPageDTO pv); //리스트
	public VideoDTO videoContentProcess(int num); // 내용
	public void updateProcess(VideoDTO dto); // 수정
	public void deleteProcess(int num); // 삭제

}
