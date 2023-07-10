package com.sportslight.memberz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportslight.common.exception.WrongEmailPasswordException;
import com.sportslight.dto.MemberzDTO;
import com.sportslight.memberz.dao.MemberzDAO;
import com.sportslight.memberz.dto.AuthInfo;
import com.sportslight.memberz.dto.ChangePwdCommand;

@Service
public class MemberzServiceImp implements MemberzService{
	
	
	@Autowired
	private MemberzDAO memberzDao;
	
	public MemberzServiceImp() {
}

	@Override
	public AuthInfo addMemberzProcess(MemberzDTO dto) {
		memberzDao.insertMemberz(dto);
		System.out.println("imp ok");
		return new AuthInfo(dto.getMemberEmail(),dto.getMemberPass(),dto.getMemberProfile());
	}

	@Override
	public AuthInfo loginProcess(MemberzDTO dto) {
		MemberzDTO member = memberzDao.selectByEmail(dto.getMemberEmail());
		
		
		if(member == null) {
			throw new WrongEmailPasswordException();
		}
		if(!member.matchPassword(dto.getMemberPass())) {
			throw new WrongEmailPasswordException();
			
		}
		return new AuthInfo(member.getMemberEmail(),member.getMemberPass(),member.getMemberProfile());
		}
		
	@Override
	public MemberzDTO updateMemberzProcess(String memberEmail) {
	   return memberzDao.selectByEmail(memberEmail);
	}

	@Override
	public AuthInfo updateMemberzProcess(MemberzDTO dto) {
	    memberzDao.updateMemberz(dto);
	    MemberzDTO member = memberzDao.selectByEmail(dto.getMemberEmail());
	    return new AuthInfo(member.getMemberEmail(), member.getMemberPass(), member.getMemberProfile());
	}

	@Override
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd) {
		MemberzDTO member = memberzDao.selectByEmail(memberEmail);
		if(member == null)
			throw new WrongEmailPasswordException();
	
		member.changePassword(changePwd.getCurrentPassword(),changePwd.getNewPassword());
		memberzDao.updateByPass(member);
	}

	@Override
	public int emailCheckProcess(String memberEmail) {
		return memberzDao.emailCheck(memberEmail);
	}

	@Override
	public int profileCheckProcess(String memberProfile) {
		return memberzDao.profileCheck(memberProfile);
	}

	@Override
	public void insertMemberFavorProcess(MemberzDTO dto) {
		 memberzDao.insertMemberzFavor(dto);
		
	}

	@Override
	public void deleteMemberProcess(String memberEmail) {
		memberzDao.deletememberz(memberEmail);
	}

	@Override
	public int duplecateprofile(MemberzDTO dto) {
		
		return memberzDao.duplecateprofile(dto);
	}

	

	
	
}//end class