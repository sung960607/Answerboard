package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.MemberVO;

@Repository
public class MemberDaoImpl implements IMemberDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS ="com.min.edu.IMemberDao.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private PasswordEncoder passendcoder;
	
	@Override
	public List<MemberVO> memberList() {
		logger.info("memberList 회원 전체 조회 입니다.");
		return session.selectList(NS+"memberList");
	}

	@Override
	public MemberVO loginMember(Map<String, Object> map) {
		MemberVO mDto = null;
		logger.info("loginMember 로그인 입니다.");
		String dbpw=session.selectOne(NS+"selStringPw",map.get("id"));
		System.out.println(passendcoder.matches((String)map.get("pw"), dbpw));
		if(passendcoder.matches((String)map.get("pw"),dbpw)) {
			return session.selectOne(NS+"enLogin", map);
		}
		
		return mDto;
	}

	@Override
	public String selStringPw(String id) {
		logger.info("selStringPw 비밀번호 암호화 입니다.");
		return session.selectOne(NS+"selStringPw", id);
	}

	@Override
	public MemberVO enLogin(Map<String, Object> map) {
		logger.info("enLogin 비밀번호 복호화 입니다.");
		return session.selectOne(NS+"enLogin", map);
	}

	@Override
	public boolean signUpMember(MemberVO vo) {
		logger.info("signUpMember 회원가입 입니다.");
		vo.setPw(passendcoder.encode(vo.getPw()));
		return (session.insert(NS+"signUpMember", vo)>0)?true:false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("idDuplicateCheck 아이디 중복체크 입니다.");
		int n=session.selectOne(NS+"idDuplicateCheck",id);
		return (n>0)?true:false;
	}

}
