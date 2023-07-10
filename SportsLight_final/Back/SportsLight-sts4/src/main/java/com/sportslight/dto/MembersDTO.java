package com.sportslight.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.sportslight.common.exception.WrongEmailPasswordException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@NoArgsConstructor
public class MembersDTO {
	
	private int memberNum; //회원 고유번호
	
	private String memberEmail; //회원 이메일
	
	private String memberPass; //회원 비밀번호
	
	private String memberProfile; //회원 프로필 이름
	
	private Date memberReg; //회원 가입일자
	
	private String memberLocked; //회원 잠금 여부
	
	private String memberLeave; //회원 탈퇴 여부
	
//	private boolean rememberEmail; // 자동 로그인
	
//	private String authRole;

	//매치가 되면 true, 매치가 되지 않으면 false
	public boolean matchPassword(String memberPass) {
		return this.memberPass.equals(memberPass);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!this.memberPass.equals(oldPassword)) //본인인지 검증
			throw new WrongEmailPasswordException();
		this.memberPass = newPassword;
	}
	
}//end class

















