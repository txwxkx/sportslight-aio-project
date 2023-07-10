package com.sportslight.memberz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sportslight.dto.MemberzDTO;

@Mapper
@Repository
public interface MemberzDAO {
	


  
	public int insertMemberz(MemberzDTO dto);
	public MemberzDTO selectByEmail(String memberEmail);
	public void updateMemberz(MemberzDTO dto);
	public void updateByPass(MemberzDTO dto);
	public int emailCheck(String memberEmail);
	public int profileCheck(String memberProfile);
	public void insertMemberzFavor(MemberzDTO dto);
	public void deletememberz(String memberEmail);
    public int duplecateprofile(MemberzDTO dto);
}
