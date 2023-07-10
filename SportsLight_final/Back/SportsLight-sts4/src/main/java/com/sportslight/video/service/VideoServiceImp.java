package com.sportslight.video.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslight.dto.HeartDTO;
import com.sportslight.dto.VideoDTO;
import com.sportslight.mymy.dao.MymyDAO;
import com.sportslight.video.dao.VideoDAO;

@Service
public class VideoServiceImp implements VideoService{
	
	@Autowired
	private VideoDAO videoDao;
	@Autowired
	private MymyDAO myDao;
	
	public VideoServiceImp() {
		
	}

	@Override
	public List<VideoDTO> leagueListProcess()  {
		
		return videoDao.leagueList();
	}
	
	@Override
	public boolean chkHeart(int memberNum) {
		List<HeartDTO> hlist = myDao.getHeartVideo(memberNum);
		System.out.println(hlist.size());
		if(hlist.size() != 0) {
			return true;
		}
			
		return false;
	};
	
	@Override
	public int getLastHeart(int memberNum) {
		List<HeartDTO> hlist = myDao.getHeartVideo(memberNum);
		return hlist.get(0).getVideoNum();
	}
	
	@Override
	public List<VideoDTO> getHeartRecommend(int []resp){
		List<VideoDTO> vlist = new ArrayList<>();
		for(int num: resp) {
			vlist.add(myDao.getHeartRecommend(num));
		}
		System.out.println(vlist);
		return vlist;
	}


	@Override
	public List<VideoDTO> recommendListProcess() {
		// TODO Auto-generated method stub
		return videoDao.recommendList();
	}

	@Override
	public List<VideoDTO> shortsListProcess() {
		// TODO Auto-generated method stub
		return videoDao.shortsList();
	}

	@Override
	public List<VideoDTO> hitsListProcess() {
		// TODO Auto-generated method stub
		return videoDao.hitsList();
	}

	@Override
	public List<VideoDTO> highlightListProcess() {
		// TODO Auto-generated method stub
		return videoDao.highlightList();
	}
	
	@Override
	public List<VideoDTO> searchProcess(String searchWord) {
		return videoDao.searchList(searchWord);
	}

	@Override
	public List<VideoDTO> premierListProcess() {
		// TODO Auto-generated method stub
		return videoDao.premierList();
	}

	@Override
	public List<VideoDTO> laligaListProcess() {
		// TODO Auto-generated method stub
		return videoDao.laligaList();
	}

	@Override
	public List<VideoDTO> serieListProcess() {
		// TODO Auto-generated method stub
		return videoDao.serieList();
	}

	@Override
	public List<VideoDTO> championsListProcess() {
		// TODO Auto-generated method stub
		return videoDao.championsList();
	}

	@Override
	public List<VideoDTO> europaListProcess() {
		// TODO Auto-generated method stub
		return videoDao.europaList();
	}

	@Override
	public List<VideoDTO> league1ListProcess() {
		// TODO Auto-generated method stub
		return videoDao.league1List();
	}

	@Override
	public List<VideoDTO> kOneListProcess() {
		// TODO Auto-generated method stub
		return videoDao.kOneList();
	}

	@Override
	public List<VideoDTO> kTwoListProcess() {
		// TODO Auto-generated method stub
		return videoDao.kOneList();
	}

	@Override
	public List<VideoDTO> bundesligaListProcess() {
		// TODO Auto-generated method stub
		return videoDao.bundesligaList();
	}

}
