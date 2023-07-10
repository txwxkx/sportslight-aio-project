package com.sportslight.schedule.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sportslight.dto.ScheduleDTO;
import com.sportslight.schedule.service.ScheduleService;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/schedule/{leagueName}")
	public Map<String, Object> scheduleListExecute(@PathVariable("leagueName") String leagueName, ScheduleDTO scheduleDto) {
		Map<String, Object> map = new HashMap<>();
		
		//유저가 선택한 리그의 모든 일정 매핑
		map.put("selectedSchedule", scheduleService.selectedScheduleListProcess(leagueName));
		
		//유저가 선택한 리그의 이번 달 일정 매핑
		map.put("recentSchedule", scheduleService.recentScheduleListProcess(leagueName));
		
//		System.out.println(map);
		
		return map;
	}
	
}//end class

