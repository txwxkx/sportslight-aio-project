package com.sportslight.memberz.dto;
//로그인 성공 후 인증 상태 정보를 세션에 보관할 때 사용한다.
public class AuthInfo {
	
	private String memberEmail;
	private String memberPass;
	private String memberProfile;
	
	public AuthInfo() {
		
	}

	public AuthInfo(String memberEmail, String memberPass) {
		this.memberEmail = memberEmail;
		this.memberPass = memberPass;
	}
	
	public AuthInfo(String memberEmail, String memberPass, String memberProfile) {
		this.memberEmail = memberEmail;
		this.memberPass = memberPass;
		this.memberProfile = memberProfile;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public String getMemberProfile() {
		return memberProfile;
	}
	
}//end class
