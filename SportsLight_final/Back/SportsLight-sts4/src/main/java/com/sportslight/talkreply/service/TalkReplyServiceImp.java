package com.sportslight.talkreply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslight.dto.TalkReplyDTO;
import com.sportslight.talkreply.dao.TalkReplyDAO;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class TalkReplyServiceImp implements TalkReplyService {
	
	@Autowired
	private TalkReplyDAO talkreplyDao;
	
	public void setBoardDao(TalkReplyDAO talkreplyDao) {
		this.talkreplyDao = talkreplyDao;
	}

	@Override
	public int replyCountProcess() {
		return talkreplyDao.replyCount();
	}
	
	@Override
	public List<TalkReplyDTO> replyListProcess(int talkNum) {
		return talkreplyDao.replyList(talkNum);
	}

	@Override
	public void replyCreateProcess(TalkReplyDTO talkreplyDto) {
		talkreplyDao.replyCreate(talkreplyDto);
	}

	@Override
	public void replyUpdateProcess(TalkReplyDTO talkreplyDto) {
		talkreplyDao.replyUpdate(talkreplyDto);
	}

	@Override
	public void replyDeleteProcess(int talkReplyNum) {
		talkreplyDao.replyDelete(talkReplyNum);
	}
	
}//end class
