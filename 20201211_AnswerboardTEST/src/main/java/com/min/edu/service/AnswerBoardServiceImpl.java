package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dao.IAnswerboardDao;
import com.min.edu.vo.AnswerBoardVO;

@Repository
public class AnswerBoardServiceImpl implements IAnswerBoardService {

	
	@Autowired
	private IAnswerboardDao iDao;
	
	@Override
	public List<AnswerBoardVO> selectAll(Map<String, Object> map) {
		return iDao.selectAll(map);
	}



	@Override
	public boolean writeBoard(AnswerBoardVO vo) {
		return iDao.writeBoard(vo);
	}

	@Override
	@Transactional
	public boolean reply(AnswerBoardVO vo) {
		return iDao.reply(vo);
	}

	@Override
	public boolean modifyBoard(AnswerBoardVO vo) {
		return iDao.modifyBoard(vo);
	}

	@Override
	public boolean delflagBoard(String seq) {
		return iDao.delflagBoard(seq);
	}

	@Override
	public boolean multiDelete(Map<String, Object> map) {
		return iDao.multiDelete(map);
	}

}
