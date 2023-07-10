package com.sportslightadmin.video.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslightadmin.video.dao.VideoDAO;
import com.sportslightadmin.video.dto.VideoDTO;
import com.sportslightadmin.video.dto.VideoPageDTO;

@Service
public class VideoServiceImp implements VideoService {
	
	
	@Autowired
	private VideoDAO videoDao;
	
	public VideoServiceImp() {
		
	}
	
	public void setVideoDao(VideoDAO videoDao) {
		this.videoDao = videoDao;
	}

	@Override
	public int countProcess() {
		return videoDao.count();
	}

	@Override
	public List<VideoDTO> videoListProcess(VideoPageDTO pv) {
		return videoDao.videoList(pv);
	}

	@Override
	public VideoDTO videoContentProcess(int num) {
		return videoDao.videoContent(num);
	}

	@Override
	public void updateProcess(VideoDTO dto) {
		videoDao.update(dto);
		
	}

	@Override
	public void deleteProcess(int num) {
		videoDao.delete(num);
		
	}

}
