package com.sportslightadmin.footballtalkReply.service;

import java.util.List;

import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyDTO;
import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyPageDTO;

public interface FootballtalkReplyService {
	public int countProcess(int replyNum); 
	public List<FootballTalkReplyDTO> footballTalkReplyListProcess(FootballTalkReplyPageDTO pv);
	public void deleteProcess(int num);

}
