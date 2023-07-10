package com.sportslightadmin.footballtalkReply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyDTO;
import com.sportslightadmin.footballtalkReply.dto.FootballTalkReplyPageDTO;

@Mapper
@Repository
public interface FootballTalkReplyDAO {
	public int count(int replyNum); 
	public List<FootballTalkReplyDTO> footballTalkReplyList(FootballTalkReplyPageDTO pv);
	public void delete(int num);

}
