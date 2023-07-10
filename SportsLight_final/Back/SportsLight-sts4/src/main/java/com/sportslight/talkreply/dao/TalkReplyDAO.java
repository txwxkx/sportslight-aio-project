package com.sportslight.talkreply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslight.dto.TalkReplyDTO;

@Mapper
@Repository
public interface TalkReplyDAO {
	
	public int replyCount();
	
	public List<TalkReplyDTO> replyList(int talkNum);
	
	public void replyCreate(TalkReplyDTO talkreplyDto);
	
	public void replyUpdate(TalkReplyDTO talkreplyDto);
	
	public void replyDelete(int talkReplyNum);
	
}//end class
