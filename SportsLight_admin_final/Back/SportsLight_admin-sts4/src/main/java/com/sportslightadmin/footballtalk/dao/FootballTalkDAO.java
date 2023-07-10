package com.sportslightadmin.footballtalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslightadmin.footballtalk.dto.FootballTalkDTO;
import com.sportslightadmin.footballtalk.dto.FootballTalkPageDTO;

@Mapper
@Repository
public interface FootballTalkDAO {
	public int count();
	public List<FootballTalkDTO> footballTalkList(FootballTalkPageDTO pv);
	public void delete(int num);

}
