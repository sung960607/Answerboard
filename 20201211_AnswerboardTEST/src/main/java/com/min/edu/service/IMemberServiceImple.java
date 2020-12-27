package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dao.IMemberDao;
import com.min.edu.vo.MemberVO;
@Repository
public class IMemberServiceImple implements IMemberService {

	
	@Autowired
	IMemberDao iMDao;
	
	
	@Override
	public List<MemberVO> memberList() {
		return iMDao.memberList();
	}

	@Override
	public boolean signUpMember(MemberVO vo) {
		return iMDao.signUpMember(vo);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		return iMDao.idDuplicateCheck(id);
	}

	@Override
	public MemberVO loginMember(Map<String, Object> map) {
		return iMDao.loginMember(map);
	}

	@Override
	public String selStringPw(String id) {
		return iMDao.selStringPw(id);
	}

	@Override
	public MemberVO enLogin(Map<String, Object> map) {
		return iMDao.enLogin(map);
	}

}
