package com.sportslight.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslight.dto.ScheduleDTO;
import com.sportslight.schedule.dao.ScheduleDAO;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ScheduleServiceImp implements ScheduleService {
	
	@Autowired
	private ScheduleDAO scheduleDao;

	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public List<ScheduleDTO> selectedScheduleListProcess(String leagueName) {
//		System.out.println(leagueName);
		return scheduleDao.selectedScheduleList(leagueName);
	}
	
	@Override
	public List<ScheduleDTO> recentScheduleListProcess(String leagueName) {
//		System.out.println(leagueName);
		return scheduleDao.recentScheduleList(leagueName);
	}
	
}//end class
