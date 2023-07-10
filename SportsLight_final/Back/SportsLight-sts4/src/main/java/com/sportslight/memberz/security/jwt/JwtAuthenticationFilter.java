package com.sportslight.memberz.security.jwt;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sportslight.dto.MemberzDTO;
import com.sportslight.memberz.security.service.PrincipalDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

//Authentication(인증)을 처리 

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authManager;

	public JwtAuthenticationFilter(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	// http://localhost:8090/login 요청을 하면 실행되는 함수 (로그인될때 실행되는 함수임.)
	@Override
	public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {

		System.out.println("JwtAuthenticationFilter => login 요청 처리를 시작함");

		ObjectMapper om = new ObjectMapper();

		try {
			MemberzDTO user = om.readValue(request.getInputStream(), MemberzDTO.class);
			// 스트림으로 정보를 가져와서 memberDTO에 넣는다.
			System.out.printf("memberEmail: %s, memeberPass: %s\n", user.getMemberEmail(), user.getMemberPass());

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					user.getMemberEmail(), user.getMemberPass());

			
			// 이메일, 패스워드를 넘겨줌

			Authentication authentication = authManager.authenticate(authenticationToken);
			// Authentication객체에 토큰값을 등록
			//System.out.println("시이이발");
			PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
//         getPrincipal의 return type은 object. 
			System.out.printf("로그인 완료됨(인증) : %s %s\n", principalDetails.getUsername(), principalDetails.getPassword());

			return authentication;
			// 관리자로 리턴

		} catch (IOException e) {
			System.out.println("오류");
		}

		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("success");

		PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

		String jwtToken = JWT.create().withSubject("mycors")
				.withExpiresAt(new Date(System.currentTimeMillis() + (60 * 1000 * 60 * 1L))) // 만료시간 3분
				.withClaim("memberProfile", principalDetails.getMemberzDTO().getMemberProfile())
				.withClaim("authRole", principalDetails.getMemberzDTO().getAuthRole())
				.withClaim("memberEmail", principalDetails.getMemberzDTO().getMemberEmail())
				.withClaim("mamberNum", principalDetails.getMemberzDTO().getMemberNum())
				.sign(Algorithm.HMAC512("mySecurityCos")); // signature을 생성하기 위한 security
		// sign에서는 알고리즘을 내보내줌

		System.out.println("jwtToken : " + jwtToken);

		// response 응답 헤더에 jwtToken 추가
		response.addHeader("Authorization", "Bearer " + jwtToken);

		final Map<String, Object> body = new HashMap<String, Object>();
		body.put("memberProfile", principalDetails.getMemberzDTO().getMemberProfile());
		body.put("memberEmail", principalDetails.getMemberzDTO().getMemberEmail());
		body.put("authRole", principalDetails.getMemberzDTO().getAuthRole());
		body.put("memberNum", principalDetails.getMemberzDTO().getMemberNum());

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), body);

		super.successfulAuthentication(request, response, chain, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		System.out.println("unsuccessfulAuthentication 실행됨");

		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("code", HttpStatus.UNAUTHORIZED.value());
		body.put("error", failed.getMessage());

		new ObjectMapper().writeValue(response.getOutputStream(), body);

		super.unsuccessfulAuthentication(request, response, failed);
	}
}