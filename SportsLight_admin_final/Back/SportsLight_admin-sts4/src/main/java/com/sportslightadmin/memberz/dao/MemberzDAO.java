package com.sportslightadmin.memberz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslightadmin.memberz.dto.MemberzDTO;
import com.sportslightadmin.memberz.dto.MemberzPageDTO;

@Mapper
@Repository
public interface MemberzDAO {
	public int count();
	public List<MemberzDTO> memberzList(MemberzPageDTO pv); // 리스트
	public MemberzDTO memberContent(int num); // 회원 정보 
	
	public void updateMemberLocked(int num); // 회원 잠금
	public void updateMemberLeave(int num); // 회원 탈퇴
	
}
