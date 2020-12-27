package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.AnswerBoardVO;

public interface IAnswerBoardService {

	public List<AnswerBoardVO> selectAll(Map<String, Object> map);
	
	public boolean writeBoard(AnswerBoardVO vo);
	
	public boolean reply(AnswerBoardVO vo);
	
	public boolean modifyBoard(AnswerBoardVO vo);
	
	public boolean delflagBoard(String seq);
	
	public boolean multiDelete(Map<String, Object> map);
	
}
