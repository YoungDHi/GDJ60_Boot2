package com.iu.base.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private memberDAO memberDAO;
	
	//password가 일치하는지 검증하는 메서드
	public boolean memberCheck(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean result = false;
		//false : error가 없음, 검증성공
		//true : error가 있음, 검증 실패
		
		//1. annotation 검증 결과
		result = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			result=true;
			bindingResult.rejectValue("passwordCheck", "member.password.notEqual");
		}
		//3. Id중복 검사
		MemberVO checkMember = memberDAO.idDuplicateCheck(memberVO);
		if(checkMember!=null) {
			log.error("==========={}============",checkMember);
			result=true;
			bindingResult.rejectValue("userName", "member.id.duplicateCheck");
		}
		
		return result;
		
	}
	
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		
		MemberVO result = memberDAO.getLogin(memberVO);
		
		
		if(result != null && memberVO.getPassword().equals(result.getPassword())) {
			log.error("password : {}",result.getPassword());
			result.setPassword(null);
			
			return result;
		} else {
			return null;
		}
		
	}
	
	public int setJoin(MemberVO memberVO, RoleVO roleVO) throws Exception {
		memberVO.setEnabled(true);
		int result = memberDAO.setJoin(memberVO);
		Map<String, Object> map = new HashMap<>();
		map.put("userName", memberVO.getUserName());
		map.put("num", 3);
		result= memberDAO.setMemberRole(map);
//		int roleNum = 0;
//		
//		
//		roleNum = memberDAO.getRoleNum(roleVO);
//		Member_RoleVO member_RoleVO = new Member_RoleVO();
//		member_RoleVO.setNum(roleNum);
//		member_RoleVO.setUserName(memberVO.getUserName());
//		result = memberDAO.setMemberRoleJoin(member_RoleVO);
		
		return result;
	}
	
	public MemberVO idDuplicateCheck(MemberVO memberVO) throws Exception {
		return memberDAO.idDuplicateCheck(memberVO);
	}
	
	public MemberVO getMyPage(MemberVO memberVO) throws Exception {
		
		memberVO = memberDAO.getLogin(memberVO);
		
		return memberVO;
	}

}
