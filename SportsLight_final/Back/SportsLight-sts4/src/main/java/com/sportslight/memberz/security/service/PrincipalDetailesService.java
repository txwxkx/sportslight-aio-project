package com.sportslight.memberz.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sportslight.dto.MemberzDTO;
import com.sportslight.memberz.dao.MemberzDAO;




@Service
public class PrincipalDetailesService implements UserDetailsService {
   
   @Autowired
   private MemberzDAO memberzdao;
   
   public PrincipalDetailesService() {
      
   }

   // 입력한 이메일을 가지고 와서 처리. 
   @Override
   public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
	   System.out.println("시이이");
      MemberzDTO memberEntity = memberzdao.selectByEmail(memberEmail);
      
      if(memberEntity==null) {
         throw new UsernameNotFoundException(memberEmail);
      }
      
      // 정상처리. adminEntity 리턴
      return new PrincipalDetails(memberEntity);
   }
}