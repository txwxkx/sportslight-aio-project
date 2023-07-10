package com.sportslight.talk.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslight.dto.TalkDTO;
import com.sportslight.dto.TalkPageDTO;
import com.sportslight.talk.dao.TalkDAO;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class TalkServiceImp implements TalkService {
	
	@Autowired
	private TalkDAO talkDao;
	
	public void setBoardDao(TalkDAO talkDao) {
		this.talkDao = talkDao;
	}

	@Override
	public int talkCountProcess() {
		return talkDao.talkCount();
	}

	@Override
	public List<TalkDTO> recentListProcess(TalkPageDTO talkpageDto) {
		return talkDao.recentList(talkpageDto);
	}
	
	@Override
	public List<TalkDTO> viewsListProcess(TalkPageDTO talkpageDto) {
		return talkDao.viewsList(talkpageDto);
	}
	
	@Override
	public List<TalkDTO> leagueListProcess(int leagueNum) {
		return talkDao.leagueList(leagueNum);
	}

	@Override
	public void talkCreateProcess(TalkDTO talkpageDto) {
		talkDao.talkCreate(talkpageDto);
	}

	@Override
	public TalkDTO talkReadProcess(int talkNum) {
		talkDao.talkViews(talkNum);
		return talkDao.talkRead(talkNum);
	}

	@Override
	public void talkUpdateProcess(TalkDTO talkDto, String urlpath) {
		String filename = talkDto.getTalkUpload();
		//수정할 첨부 파일이 있으면
		if(filename != null) {
			String path = talkDao.talkUpload(talkDto.getTalkNum());
			//기존 첨부 파일이 있으면
			if(path != null) {
				File file = new File(urlpath, path);
				file.delete();
			}
		}
		talkDao.talkUpdate(talkDto);
	}

	@Override
	public void talkDeleteProcess(int talkNum, String urlpath) {
		String path = talkDao.talkUpload(talkNum);
		if(path!=null) {
			File file = new File(urlpath, path);
			file.delete();
		}
		talkDao.talkDelete(talkNum);
	}

	@Override
	public String talkFileSelectprocess(int talkNum) {
		return null;
	}
	
}//end class
