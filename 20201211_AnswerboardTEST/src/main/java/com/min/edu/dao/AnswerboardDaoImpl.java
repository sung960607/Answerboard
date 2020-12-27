package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.vo.AnswerBoardVO;

@Repository
public class AnswerboardDaoImpl implements IAnswerboardDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS ="com.min.edu.dao.IAnswerboardDao.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<AnswerBoardVO> selectAll(Map<String, Object> map) {
		logger.info("selectAll 전체 조회 입니다.");
		return session.selectList(NS+"selectAll",map);
	}

	@Override
	public boolean writeBoard(AnswerBoardVO vo) {
		logger.info("writeBoard root 글쓰기 입니다.");
		return (session.insert(NS+"writeBoard", vo)>0)?true:false;
	}

	@Override
	@Transactional
	public boolean reply(AnswerBoardVO vo) {
		logger.info("reply 답글 입니다.");
		int cnt=0;
		cnt+=session.update(NS+"replyBoardUp", vo);
		cnt+=session.insert(NS+"replyBoardIn",vo);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean modifyBoard(AnswerBoardVO vo) {
		logger.info("modifyBoard 글수정 입니다.");
		int cnt=session.update(NS+"modifyBoard",vo);
		return (cnt>0)?true:false; 
	}

	@Override
	public boolean delflagBoard(String seq) {
		logger.info("delflagBoard 글 삭제 입니다.");
		return (session.update(NS+"delflagBoard", seq)>0)?true:false;
	}

	@Override
	public boolean multiDelete(Map<String, Object> map) {
		logger.info("multiDelete 글 삭제 입니다.");
		return (session.update(NS+"multiDelete", map)>0)?true:false;
	}

}
