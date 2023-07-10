package com.sportslightadmin.video.dto;

import org.springframework.stereotype.Component;

import com.sportslightadmin.team.dto.TeamDTO;
import com.sportslightadmin.videoBoard.dto.VideoBoardDTO;

@Component
public class VideoDTO {
	private int videoNum, videoViews;
	private String videoName, thumbnailUrl, videoUrl;
	private char videoType;
	private int teamNum1, teamNum2;
	private int leagueNum, seasonNum;
	private VideoBoardDTO videoBoardDTO;
	private TeamDTO teamDTO;
	private String teamName1, teamName2;

	
	
	public VideoDTO() {

	}

	public String getTeamName1() {
		return teamName1;
	}

	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}

	public String getTeamName2() {
		return teamName2;
	}

	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
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

	public char getVideoType() {
		return videoType;
	}

	public void setVideoType(char videoType) {
		this.videoType = videoType;
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

	public VideoBoardDTO getVideoBoardDTO() {
		return videoBoardDTO;
	}

	public void setVideoBoardDTO(VideoBoardDTO videoBoardDTO) {
		this.videoBoardDTO = videoBoardDTO;
	}

	public TeamDTO getTeamDTO() {
		return teamDTO;
	}

	public void setTeamDTO(TeamDTO teamDTO) {
		this.teamDTO = teamDTO;
	}
	
	

}
