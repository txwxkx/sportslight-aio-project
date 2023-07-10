package com.sportslightadmin.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslightadmin.notice.dto.NoticeDTO;
import com.sportslightadmin.notice.dto.NoticePageDTO;

@Mapper
@Repository
public interface NoticeDAO {
	public int count(); // 페이징 처리 위한 카운트
	public List<NoticeDTO> noticeList(NoticePageDTO pv); // 리스트
	public NoticeDTO noticeContent(int num); // 내용
	public void save(NoticeDTO dto); // 저장
	public void update(NoticeDTO dto); // 수정
	public void delete(int num); // 삭제

}
