package com.sportslightadmin.footballtalkReply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslightadmin.footballtalkReply.dao.FootballTalkReplyDAO;
import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyDTO;
import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyPageDTO;


@Service
public class FootballtalkReplyServiceImp implements FootballtalkReplyService{
	
	@Autowired
	private FootballTalkReplyDAO footballTalkRelyDao;
	
	public FootballtalkReplyServiceImp() {
		
	}


	public void setFootballTalkRelyDao(FootballTalkReplyDAO footballTalkRelyDao) {
		this.footballTalkRelyDao = footballTalkRelyDao;
	}



	@Override
	public int countProcess(int replyNum) {
		return footballTalkRelyDao.count(replyNum);
	}

	@Override
	public List<FootballTalkReplyDTO> footballTalkReplyListProcess(FootballTalkReplyPageDTO pv) {
		return footballTalkRelyDao.footballTalkReplyList(pv);
	}

	@Override
	public void deleteProcess(int num) {
		footballTalkRelyDao.delete(num);
		
	}

}















