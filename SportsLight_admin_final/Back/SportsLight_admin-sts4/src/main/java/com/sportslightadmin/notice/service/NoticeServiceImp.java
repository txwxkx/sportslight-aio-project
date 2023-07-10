package com.sportslightadmin.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslightadmin.notice.dao.NoticeDAO;
import com.sportslightadmin.notice.dto.NoticeDTO;
import com.sportslightadmin.notice.dto.NoticePageDTO;

@Service
public class NoticeServiceImp implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDao;
	
	public NoticeServiceImp() {
		
	}
	
	public void setNoticeDao(NoticeDAO noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public int countProcess() {
		return noticeDao.count();
	}

	@Override
	public List<NoticeDTO> noticeListProcess(NoticePageDTO pv) {
		return noticeDao.noticeList(pv);
	}

	@Override
	public NoticeDTO contentProcess(int num) {
		return noticeDao.noticeContent(num);
	}

	@Override
	public void insertProcess(NoticeDTO dto) {
		noticeDao.save(dto);
		
	}

	@Override
	public void updateProcess(NoticeDTO dto) {
		noticeDao.update(dto);
		
	}

	@Override
	public void deleteProcess(int num) {
		noticeDao.delete(num);
		
	}

}
