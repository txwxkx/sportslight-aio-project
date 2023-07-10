package com.sportslight.dto;

import java.util.Date;



import org.springframework.stereotype.Component;

import com.sportslight.common.exception.WrongEmailPasswordException;



@Component
public class MemberzDTO {
	
@Override
	public String toString() {
		return "MemberzDTO [memberEmail=" + memberEmail + ", memberPass=" + memberPass + ", memberProfile="
				+ memberProfile + ", memberReg=" + memberReg + ", memberLocked=" + memberLocked + ", memberLeave="
				+ memberLeave + ", rememberEmail=" + rememberEmail + ", authRole=" + authRole + ", memberNum="
				+ memberNum + ", leagueNum1=" + leagueNum1 + ", leagueNum2=" + leagueNum2 + ", leagueNum3=" + leagueNum3
				+ "]";
	}



	//	@NotBlank(message="이메일을 입력해주세요.") //입력폼이 비어있는 상태로 요청을 보내면 해당 에러메세지가 뜬다
//	@Email(message ="올바른 이메일 주소를 입력해주세요.") //이메일 형태만 입력이 가능하다.
	private String memberEmail; //회원 이메일
	
//	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String memberPass; //회원 비밀번호₩	
	
//	@NotBlank(message = "닉네임을 입력해주세요.")
//	@Size(min = 2, max = 15, message = "닉네임은 2 ~ 15 사이 입력해주세요") //지정된 사이즈에 벗어나는 값 입력시 에러메세지가 나타난다.
	private String memberProfile; //회원 닉네임
	
	private Date memberReg;  //가입한 날
	private char memberLocked;//계정 잠김 여부
    private char memberLeave;//탈퇴한 회원인지 아닌지 
    private boolean rememberEmail; //자동 로그인
    private String authRole;
    private int memberNum; 
    private int leagueNum1;
    private int leagueNum2;
    private int leagueNum3;
    
    
    public int getLeagueNum1() {
		return leagueNum1;
	}

	public void setLeagueNum1(int leagueNum1) {
		this.leagueNum1 = leagueNum1;
	}

	public int getLeagueNum2() {
		return leagueNum2;
	}

	public void setLeagueNum2(int leagueNum2) {
		this.leagueNum2 = leagueNum2;
	}

	public int getLeagueNum3() {
		return leagueNum3;
	}

	public void setLeagueNum3(int leagueNum3) {
		this.leagueNum3 = leagueNum3;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public MemberzDTO() {
    	
    }
    
    public String getAuthRole() {
    	return authRole;
    }
    
    public void setAuthRole(String authRole) {
    	this.authRole = authRole;
    }
    
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberProfile() {
		return memberProfile;
	}
	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}
	public Date getMemberReg() {
		return memberReg;
	}
	public void setMemberReg(Date memberReg) {
		this.memberReg = memberReg;
	}
	public char getMemberLocked() {
		return memberLocked;
	}
	public void setMemberLocked(char memberLocked) {
		this.memberLocked = memberLocked;
	}
	public char getMemberLeave() {
		return memberLeave;
	}
	public void setMemberLeave(char memberLeave) {
		this.memberLeave = memberLeave;
	}
	
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	public boolean matchPassword(String memberPass) {
		return this.memberPass.equals(memberPass);
		// DB에 입력되어있는 pw와 입력한 pw가 동일한
		//매치가 되면 True, 안되면 False 
	}
	
	
	
	//DB에 입력되어 있는 pw와 현재비번호 입력의 
	public void changePassword(String oldPassword, String newPassword) {
		if (!this.memberPass.equals(oldPassword)) //본인인지 인하기 위함
		  throw new WrongEmailPasswordException();
		this.memberPass = newPassword;
	
	}

}// end class

