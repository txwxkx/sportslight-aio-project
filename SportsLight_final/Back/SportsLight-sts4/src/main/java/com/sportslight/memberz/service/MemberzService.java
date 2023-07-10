package com.sportslight.memberz.service;



import com.sportslight.dto.MemberzDTO;
import com.sportslight.memberz.dto.AuthInfo;
import com.sportslight.memberz.dto.ChangePwdCommand;


public interface MemberzService {
	
	public AuthInfo addMemberzProcess(MemberzDTO dto);
	public AuthInfo loginProcess(MemberzDTO dto);
	
	
	public MemberzDTO updateMemberzProcess(String memberEmail);
	public AuthInfo updateMemberzProcess(MemberzDTO dto);
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd );
    public int emailCheckProcess(String memberEmail);
    public int profileCheckProcess(String memberProfile);
    public void insertMemberFavorProcess(MemberzDTO dto);
    public void deleteMemberProcess(String memberEmail);
    public int duplecateprofile(MemberzDTO dto);
    
}
