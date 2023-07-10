package com.sportslight.memberz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportslight.dto.MemberzDTO;
import com.sportslight.memberz.dto.AuthInfo;
import com.sportslight.memberz.service.MemberzService;

import lombok.NoArgsConstructor;

@CrossOrigin(origins = {"http://localhost:3000"})
@NoArgsConstructor
@RestController
public class MemberzController {
	
	//비밀번호 암호화 처리 
	@Autowired
	private MemberzService memberzService;
	
	@Autowired
	private BCryptPasswordEncoder encodePassword;
	
	//회원가입 처리 //아이디 닉네임 체크
@PostMapping("/signup")
public String addMemberz(@RequestBody MemberzDTO memberzDTO) {
    int count = memberzService.emailCheckProcess(memberzDTO.getMemberEmail());
    int counts = memberzService.profileCheckProcess(memberzDTO.getMemberProfile());
   System.out.println(counts);
	  if(count > 0 && counts > 0) { 
		  
	      return "DUPLICATE_PROFILE_PROFILE";
	    } else if (count > 0) {
	    	return "DUPLICATE_EMAIL";
	    } else if (counts > 0) {   
	    	return "DUPLICATE_PROFILE";
	    }else {
	    

	    	memberzDTO.setMemberPass(encodePassword.encode(memberzDTO.getMemberPass()));
//	    	memberzService.insertMemberFavorProcess(memberzDTO);
	        System.out.println("시작");
	    	AuthInfo authInfo = memberzService.addMemberzProcess(memberzDTO);
	    	memberzService.insertMemberFavorProcess(memberzDTO);
	    	return "SUCCESS";
	    }

	    
	   
}//end addMember(
@GetMapping("/memberz/editinfo/{memberEmail}")
public MemberzDTO getMember(@PathVariable("memberEmail")String memberEmail) {
	System.out.println(memberEmail);
	return memberzService.updateMemberzProcess(memberEmail);
}//end getMember()


//회원정보 수정 처리 
@PostMapping("/memberz/update")
public String updateMemberz(@RequestBody MemberzDTO memberzDTO) {
	System.out.println(memberzDTO);
	if(memberzService.duplecateprofile(memberzDTO)==1) {
		return "fail";
	}
	memberzDTO.setMemberPass(encodePassword.encode(memberzDTO.getMemberPass()));
	memberzService.updateMemberzProcess(memberzDTO);
       return "sucess";
	
}

//회원탈퇴기능 
@PostMapping("/memberz/memberWithdraw/{memberEmail}")
public void deletememberz(@PathVariable("memberEmail")String memberEmail) {
	memberzService.deleteMemberProcess(memberEmail);
}


	



}//end class
