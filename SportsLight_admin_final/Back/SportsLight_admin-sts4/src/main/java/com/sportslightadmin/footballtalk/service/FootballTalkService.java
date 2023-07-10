package com.sportslightadmin.footballtalk.service;

import java.util.List;

import com.sportslightadmin.footballtalk.dto.FootballTalkDTO;
import com.sportslightadmin.footballtalk.dto.FootballTalkPageDTO;

public interface FootballTalkService {
	public int countProcess();
	public List<FootballTalkDTO> footballTalkListProcess(FootballTalkPageDTO pv);
	public void deleteProcess(int num);

}
