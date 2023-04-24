package com.iu.base.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private memberDAO memberDAO;
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		
		MemberVO result = memberDAO.getLogin(memberVO);
		
		
		if(result != null && memberVO.getPassword().equals(result.getPassword())) {
			log.error("password : {}",result.getPassword());
			memberVO.setPassword(null);
			memberVO.setRoleVOs(result.getRoleVOs());
			return memberVO;
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
