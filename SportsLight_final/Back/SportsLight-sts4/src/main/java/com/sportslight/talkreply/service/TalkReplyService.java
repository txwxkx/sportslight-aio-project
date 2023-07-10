package com.sportslight.talkreply.service;

import java.util.List;

import com.sportslight.dto.TalkReplyDTO;

public interface TalkReplyService {
	
	public int replyCountProcess();
	
	public List<TalkReplyDTO> replyListProcess(int talkNum);
	
	public void replyCreateProcess(TalkReplyDTO talkreplyDto);
	
	public void replyUpdateProcess(TalkReplyDTO talkreplyDto);
	
	public void replyDeleteProcess(int talkReplyNum);
	
}//end class
