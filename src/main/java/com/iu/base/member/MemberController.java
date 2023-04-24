package com.iu.base.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView getLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getLogin(memberVO);
		mv.setViewName("redirect:./login");
		if(memberVO !=null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView getLogout(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView setJoin() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setjoin(MemberVO memberVO, RoleVO roleVO) throws Exception {
		
		int result=memberService.setJoin(memberVO, roleVO);
		
		ModelAndView mv = new ModelAndView();
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
