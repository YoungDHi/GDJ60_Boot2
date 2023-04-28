package com.iu.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.iu.base.security.UserLogoutSuccessHandler;
import com.iu.base.security.UserSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserLogoutSuccessHandler userLogoutSuccessHandler;
	
	@Bean
	//public을 선언하면 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityConfig() {
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.cors()
				.and()
				.csrf()
				.disable()
			.authorizeRequests()
				//URL과 권한 매칭
				.antMatchers("/").permitAll()
				.antMatchers("/member/join").permitAll()
				.antMatchers("/member/findPassword").permitAll()
				.antMatchers("/notice/add").hasRole("ADMIN")
				.antMatchers("/notice/update").hasRole("ADMIN")
				.antMatchers("/notice/delete").hasRole("ADMIN")
				.antMatchers("/notice/*").permitAll()
				.antMatchers("/qna/add").hasAnyRole("ADMIN","MEMBER","MANAGER")
				.anyRequest().authenticated()
//				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/member/login")
//				.defaultSuccessUrl("/")
				.successHandler(new UserSuccessHandler())
				.failureUrl("/member/login")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/member/logout")
				.logoutSuccessHandler(userLogoutSuccessHandler)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				;
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
