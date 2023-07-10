package com.sportslight.schedule.service;

import java.util.List;

import com.sportslight.dto.ScheduleDTO;

public interface ScheduleService {
	
	public List<ScheduleDTO> selectedScheduleListProcess(String leagueName);
	
	public List<ScheduleDTO> recentScheduleListProcess(String leagueName);
	
}//end class