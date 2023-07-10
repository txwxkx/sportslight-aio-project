package com.sportslight.dto;



public class VideoDTO {
	private int videoNum;
	private int videoViews;
	private int teamNum1;
	private int teamNum2;
	private int leagueNum;
	private int seasonNum;
	private String videoName;
	private String searchWord;
	private String thumbnailUrl;
	private String videoUrl;
	private String videotype;
	
	public VideoDTO () {
		
	}
	
	public VideoDTO(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public int getVideoViews() {
		return videoViews;
	}

	public void setVideoViews(int videoViews) {
		this.videoViews = videoViews;
	}

	public int getTeamNum1() {
		return teamNum1;
	}

	public void setTeamNum1(int teamNum1) {
		this.teamNum1 = teamNum1;
	}

	public int getTeamNum2() {
		return teamNum2;
	}

	public void setTeamNum2(int teamNum2) {
		this.teamNum2 = teamNum2;
	}

	public int getLeagueNum() {
		return leagueNum;
	}

	public void setLeagueNum(int leagueNum) {
		this.leagueNum = leagueNum;
	}

	public int getSeasonNum() {
		return seasonNum;
	}

	public void setSeasonNum(int seasonNum) {
		this.seasonNum = seasonNum;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideotype() {
		return videotype;
	}

	public void setVideotype(String videotype) {
		this.videotype = videotype;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

}
