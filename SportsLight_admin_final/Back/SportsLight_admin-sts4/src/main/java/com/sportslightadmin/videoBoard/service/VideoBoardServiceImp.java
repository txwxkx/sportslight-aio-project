package com.sportslightadmin.videoBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslightadmin.video.dao.VideoDAO;
import com.sportslightadmin.videoBoard.dao.VideoBoardDAO;
import com.sportslightadmin.videoBoard.dto.VideoBoardDTO;
import com.sportslightadmin.videoBoard.dto.VideoBoardPageDTO;

@Service
public class VideoBoardServiceImp implements VideoBoardService {
	
	@Autowired
	private VideoBoardDAO videoBoardDao;
	
	public VideoBoardServiceImp() {
		
	}
	
	public void setVideoBoardDao(VideoBoardDAO videoBoardDao) {
		this.videoBoardDao = videoBoardDao;
	}

	@Override
	public int countProcess(int videoNum) {
		return videoBoardDao.count(videoNum);
	}

	@Override
	public List<VideoBoardDTO> videoBoardListProcess(VideoBoardPageDTO pv) {
		return videoBoardDao.videoBoardList(pv);
	}

	@Override
	public void deleteProcess(int num) {
		videoBoardDao.delete(num);
		
	}
	

}
