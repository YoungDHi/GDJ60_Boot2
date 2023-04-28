package com.iu.base.member;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.iu.base.util.MailManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService {
	
	@Autowired
	private memberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MailManager mailManager;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.error("============= Spring Security Login==============");
		log.error("============= {} ================", username);
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		try {
			memberVO=memberDAO.getLogin(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberVO;
	}
	
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
			bindingResult.rejectValue("username", "member.id.duplicateCheck");
		}
		
		return result;
		
	}
	
	
//	public MemberVO getLogin(MemberVO memberVO) throws Exception {
//		
//		MemberVO result = memberDAO.getLogin(memberVO);
//		
//		
//		if(result != null && memberVO.getPassword().equals(result.getPassword())) {
//			log.error("password : {}",result.getPassword());
//			result.setPassword(null);
//			
//			return result;
//		} else {
//			return null;
//		}
//		
//	}
	
	public boolean getFindPassword(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean result = false;
		
		result = bindingResult.hasErrors();
		log.error("=========== result1 : {} ===========", result);

		if(memberDAO.getFindPassword(memberVO) != null) {
//			String charaters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//			SecureRandom random = new SecureRandom();
//			StringBuffer sb = new StringBuffer(6);
//			for(int i = 0;i<6;i++) {
//				sb.append(charaters.charAt(random.nextInt(charaters.length())));
//			}
//			String password = sb.toString();
//			mailManager.send(memberVO.getEmail(), "임시 비밀번호 입니다", "임시비밀번호는 " + password + "입니다.");
//			memberVO.setPassword(passwordEncoder.encode(password));
//			memberDAO.setPasswordUpdate(memberVO);
			log.error("=========== result2 : {} ===========", result);

		} else {
			bindingResult.rejectValue("email", "member.username.email");
			result = true;
			log.error("=========== result3 : {} ===========", result);

			
		}
		
		return result;
		
	}
	
	public int setLastTimeUpdate(MemberVO memberVO) throws Exception {
		return memberDAO.setLastTimeUpdate(memberVO);
	}
	
	public int setJoin(MemberVO memberVO, RoleVO roleVO) throws Exception {
		//memberVO.setEnabled(true);
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		int result = memberDAO.setJoin(memberVO);
		Map<String, Object> map = new HashMap<>();
		map.put("username", memberVO.getUsername());
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
