package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.service.IAnswerBoardService;
import com.min.edu.vo.AnswerBoardVO;

@Controller
public class AnsweroboardCtrl {

	@Autowired
	IAnswerBoardService iservice;
	
	@RequestMapping(value = "/answerboard.do",method = RequestMethod.GET)
	public String answerBoard(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		model.addAttribute("lists", iservice.selectAll(map));
		return "answer";
	}
	
	@RequestMapping(value = "/write.do",method = RequestMethod.GET)
	public String writeBoard() {
		return "write";
	}
	
	@RequestMapping(value = "/writeboard.do",method = RequestMethod.POST)
	public String writeBoardIn(AnswerBoardVO vo,Model model) {
		iservice.writeBoard(vo);
		return "redirect:/answerboard.do";
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String answerBoarddetail(String seq,Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		model.addAttribute("list",iservice.selectAll(map));
		return "detatil";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String answerBoardInsert(String seq,Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		model.addAttribute("list", iservice.selectAll(map));
		return "modify";
	}
	
	@RequestMapping(value = "/modifyinsert.do", method = RequestMethod.POST)
	public String answerBoardModify(AnswerBoardVO vo) {
		iservice.modifyBoard(vo);
		return "redirect:/answerboard.do";
	}
	@RequestMapping(value = "/delflag.do" ,method = RequestMethod.GET)
	public String answerBoardDel(String seq) {
		iservice.delflagBoard(seq);
		return "redirect:/answerboard.do";
	}
	
	@RequestMapping(value = "/mutilDel.do", method = RequestMethod.POST)
	public String answerBoardmutiDel(String [] chk) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqs", chk);
		iservice.multiDelete(map);
		return "redirect:/answerboard.do";
	}
	
	@RequestMapping(value = "/reply.do",method = RequestMethod.GET)
	public String reply(String seq,Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		model.addAttribute("id", iservice.selectAll(map).get(0).getId());
		model.addAttribute("seq", seq);
		return "reply";
	}
	
	@RequestMapping(value = "/replyIn.do",method = RequestMethod.POST)
	public String replyIn(AnswerBoardVO vo) {
		iservice.reply(vo);
		return "redirect:/answerboard.do";
	}
}
