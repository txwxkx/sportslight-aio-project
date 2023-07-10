package com.sportslightadmin.footballtalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslightadmin.footballtalk.dao.FootballTalkDAO;
import com.sportslightadmin.footballtalk.dto.FootballTalkDTO;
import com.sportslightadmin.footballtalk.dto.FootballTalkPageDTO;

@Service
public class FootballTalkServiceImp implements FootballTalkService{
	
	@Autowired
	private FootballTalkDAO footballTalkDao;
	
	public FootballTalkServiceImp() {
		
	}
	
	public void setFootballTalkDao(FootballTalkDAO footballTalkDao) {
		this.footballTalkDao = footballTalkDao;
	}
	

	@Override
	public int countProcess() {
		return footballTalkDao.count();
	}

	@Override
	public List<FootballTalkDTO> footballTalkListProcess(FootballTalkPageDTO pv) {
		return footballTalkDao.footballTalkList(pv);
	}

	@Override
	public void deleteProcess(int num) {
		footballTalkDao.delete(num);
		
	}

}
