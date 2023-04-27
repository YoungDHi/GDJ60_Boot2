package com.iu.base.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface memberDAO {
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	public int setLastTimeUpdate(MemberVO memberVO) throws Exception;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(Map<String, Object> map) throws Exception;
	
//	public int getRoleNum(RoleVO roleVO) throws Exception;
//	
//	public int setMemberRoleJoin(Member_RoleVO member_RoleVO) throws Exception;
	
	public MemberVO idDuplicateCheck(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getList() throws Exception;
	
	public int setEnabled() throws Exception;
	
//	public int getLastTime(MemberVO memberVO) throws Exception;
//	
//	public int setEnabledUpdate(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getBirth() throws Exception;
//	public int setBirthUser() throws Exception;

}
