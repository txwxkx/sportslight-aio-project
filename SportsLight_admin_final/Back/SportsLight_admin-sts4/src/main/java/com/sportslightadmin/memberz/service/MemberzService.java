package com.sportslightadmin.memberz.service;

import java.util.List;

import com.sportslightadmin.memberz.dto.MemberzDTO;
import com.sportslightadmin.memberz.dto.MemberzPageDTO;

public interface MemberzService {
	public int countProcess();
	public List<MemberzDTO> memberzListProcess(MemberzPageDTO pv);
	public MemberzDTO contentProcess(int num);
	public void memberLockedProcess(int num);
	public void memberLeaveProcess(int num);

}
