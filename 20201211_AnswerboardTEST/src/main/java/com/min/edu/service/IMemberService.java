package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MemberVO;

public interface IMemberService {

	public List<MemberVO> memberList();
	
	public boolean signUpMember(MemberVO vo);
	
	public boolean idDuplicateCheck(String id);
	
	public MemberVO loginMember(Map<String, Object> map);
	
	public String selStringPw(String id);
	
	public MemberVO enLogin(Map<String, Object> map);
	
}
