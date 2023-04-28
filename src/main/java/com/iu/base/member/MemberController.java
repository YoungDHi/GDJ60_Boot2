package com.iu.base.member;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public ModelAndView getLogin(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		if(obj==null) {
			mv.setViewName("member/login");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@GetMapping("findPassword")
	public ModelAndView getFindPassword(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/findPassword");
		return mv;
	}
	
	@PostMapping("findPassword")
	public ModelAndView getfindPassowrd(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean check = memberService.getFindPassword(memberVO, bindingResult);
		if(check) {
			mv.setViewName("member/findPassword");
			return mv;
		}
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("info")
	public void info(HttpSession session) {
		log.error("============= Login Info===============");
		//SPRING_SECURITY_CONTEXT
//		Enumeration<String> names=session.getAttributeNames();
//		while(names.hasMoreElements()) {
//			log.error("=========== {} ==========", names.nextElement());
//		}
		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
		SecurityContextImpl contextImpl = (SecurityContextImpl)obj;
		Authentication authentication=contextImpl.getAuthentication();
		log.error("========= {}========", obj);
		log.error("========= Name : {}========", authentication.getName());
		log.error("========= Detail : {}========", authentication.getDetails());
		log.error("========= principal : {}========", authentication.getPrincipal());
	}
	
	
	
//	@PostMapping("login")
//	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		memberVO = memberService.getLogin(memberVO);
//		mv.setViewName("redirect:./login");
//		if(memberVO !=null) {
//			session.setAttribute("member", memberVO);
//			mv.setViewName("redirect:../");
//		}
//		return mv;
//	}
	
	@GetMapping("logout")
	public ModelAndView getLogout(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.setLastTimeUpdate(memberVO);
		session.invalidate();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView setJoin(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setjoin(@Valid MemberVO memberVO, BindingResult bindingResult, RoleVO roleVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boolean check=memberService.memberCheck(memberVO, bindingResult);
		
		if(check) {
			mv.setViewName("member/join");
			return mv;
		}
		
		int result=memberService.setJoin(memberVO, roleVO);
		
		mv.setViewName("redirect:./login");
		return mv;
	}
	
	@GetMapping("idDuplicateCheck")
	@ResponseBody
	public int idDuplicateCheck(MemberVO memberVO) throws Exception {
		log.debug("===================== ID 중복 체크 ========================");
		if(memberService.idDuplicateCheck(memberVO)!=null) {
			return 0;
		}
		return 1;
	}
	
	@GetMapping("admin")
	public void getAdmin() throws Exception{
		
	}
	
	@GetMapping("myPage")
	public void getMyPage() throws Exception {
		
	}
	
//	@GetMapping("myPage")
//	public ModelAndView getMyPage(HttpSession session) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		MemberVO memberVO = (MemberVO)session.getAttribute("member");
//		memberVO = memberService.getMyPage(memberVO);
//		
//		mv.addObject("memberVO", memberVO);
//		mv.setViewName("member/myPage");
//		
//		return mv;
//	}

}
