package com.sportslightadmin.video.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslightadmin.video.dto.VideoDTO;
import com.sportslightadmin.video.dto.VideoPageDTO;

@Mapper
@Repository
public interface VideoDAO {
	public int count(); // 페이징 처리를 위한 카운트
	public List<VideoDTO> videoList(VideoPageDTO pv); //리스트
	public VideoDTO videoContent(int num); // 내용
	public void update(VideoDTO dto); // 수정
	public void delete(int num); // 삭제

}
