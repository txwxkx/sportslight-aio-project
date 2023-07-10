package com.sportslightadmin.memberz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslightadmin.memberz.dao.MemberzDAO;
import com.sportslightadmin.memberz.dto.MemberzDTO;
import com.sportslightadmin.memberz.dto.MemberzPageDTO;

@Service
public class MemberzServiceImp implements MemberzService{
	
	@Autowired
	private MemberzDAO memberzDao;
	
	public MemberzServiceImp() {
		
	}
	
	public void setMemberzDao(MemberzDAO memberzDao) {
		this.memberzDao = memberzDao;
	}

	@Override
	public int countProcess() {
		return memberzDao.count();
	}

	@Override
	public List<MemberzDTO> memberzListProcess(MemberzPageDTO pv) {
		return memberzDao.memberzList(pv);
	}

	@Override
	public MemberzDTO contentProcess(int num) {
		return memberzDao.memberContent(num);
	}

	@Override
	public void memberLockedProcess(int num) {
		memberzDao.updateMemberLocked(num);
		
	}

	@Override
	public void memberLeaveProcess(int num) {
		memberzDao.updateMemberLeave(num);
		
	}

}
