package com.sportslightadmin.notice.service;

import java.util.List;


import com.sportslightadmin.notice.dto.NoticeDTO;
import com.sportslightadmin.notice.dto.NoticePageDTO;

public interface NoticeService {
	public int countProcess();
	public List<NoticeDTO> noticeListProcess(NoticePageDTO pv); 
	public NoticeDTO contentProcess(int num);
	public void insertProcess(NoticeDTO dto);
	public void updateProcess(NoticeDTO dto);
	public void deleteProcess(int num);

}
