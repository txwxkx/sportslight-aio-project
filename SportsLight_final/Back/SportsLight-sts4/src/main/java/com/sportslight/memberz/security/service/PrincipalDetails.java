package com.sportslight.memberz.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sportslight.dto.MemberzDTO;

public class PrincipalDetails implements UserDetails {
	
	
	private MemberzDTO memberzDTO;
	
	public PrincipalDetails() {
		
	}
	
    public PrincipalDetails(MemberzDTO memberzDTO) {
    	this.memberzDTO = memberzDTO;
    }
    public MemberzDTO getMemberzDTO() {
    	return memberzDTO;
    }

    //권한 목록울 리
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
	     Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		 collect.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				
				return memberzDTO.getAuthRole();
			}
			 
		 });
		 
		 return collect;
	}

	@Override
	public String getPassword() {
		return memberzDTO.getMemberPass();
		
		}

	@Override
	public String getUsername() {
		 
		return memberzDTO.getMemberEmail();
	}

	//계정만료여부리턴 true(만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정의 잠김여부 리턴 = true(잠기지않음)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	// 비밀번호의 잠김여부 리턴-true(잠기지 않음)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정의 활성화 여부 리턴 - true(활성화됨)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    

    
}