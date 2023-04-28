package com.iu.base.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserLoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.error("======= {} =======", exception);
		log.error("======= {} =======", exception.getMessage());
		String errorMessage="";
		if(exception instanceof BadCredentialsException) {
			errorMessage="비번 틀림";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "없는 ID";
		} else if(exception instanceof DisabledException) {
			errorMessage="유효하지 않은 사용자입니다";
		} else if(exception instanceof LockedException) {
			errorMessage = "계정이 잠겨있습니다";
		} else if(exception instanceof AccountExpiredException) {
			errorMessage = "계정이 만료되었습니다";
		} else if(exception instanceof CredentialsExpiredException) {
			errorMessage = "자격 증명 유효 기간이 만료되었습니다.";
		}
		else {
			errorMessage = "로그인 실패";
		}
		
		errorMessage = URLEncoder.encode(errorMessage,"UTF-8");
		response.sendRedirect("/member/login?errorMessage="+errorMessage);
		
	}
	
	

}
