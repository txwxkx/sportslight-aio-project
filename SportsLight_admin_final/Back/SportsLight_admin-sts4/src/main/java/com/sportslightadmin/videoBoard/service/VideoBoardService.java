package com.sportslightadmin.videoBoard.service;

import java.util.List;

import com.sportslightadmin.videoBoard.dto.VideoBoardDTO;
import com.sportslightadmin.videoBoard.dto.VideoBoardPageDTO;


public interface VideoBoardService {
	public int countProcess(int videoNum);
	public List<VideoBoardDTO> videoBoardListProcess(VideoBoardPageDTO pv);
	public void deleteProcess(int num);

}
