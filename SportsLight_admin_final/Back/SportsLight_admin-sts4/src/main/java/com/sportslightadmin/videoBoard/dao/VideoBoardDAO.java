package com.sportslightadmin.videoBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslightadmin.videoBoard.dto.VideoBoardDTO;
import com.sportslightadmin.videoBoard.dto.VideoBoardPageDTO;

@Mapper
@Repository
public interface VideoBoardDAO {
	public int count(int videoNum);
	public List<VideoBoardDTO> videoBoardList(VideoBoardPageDTO pv);
	public void delete(int num); // 삭제

}


