package com.multi.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.multi.erp.board.BoardDAO;
import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
public class BoardController {
	BoardService service;

	public BoardController() {
		super();
	}

	@Autowired
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public ModelAndView writePage() {
		ModelAndView mav = new ModelAndView("board/write");
		return mav;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public ModelAndView write(BoardDTO board) {
		ModelAndView mav = new ModelAndView("main/index");
		System.out.println("board → " + board);
		service.insert(board);
		return mav;
	}

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("menu/board");
		List<BoardDTO> list = service.boardList();
		mav.addObject("boardList", list);
		return mav;
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView delete(String board_no) {
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		service.delete(board_no);
		return mav;
	}

	@RequestMapping(value = "/board/read.do")
	public ModelAndView read(String board_no , String state) {
		ModelAndView mav = new ModelAndView();
		BoardDTO Board = service.getBoardInfo(board_no);
		String view="";
		switch (state) {
		case "READ":
			view = "board/read";
			break;
		default:
			view = "board/update";
			break;
		}
		mav.setViewName(view);
		mav.addObject("board", Board);
		return mav;
	}

	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public ModelAndView update(BoardDTO board) {
		ModelAndView mav = new ModelAndView("board/read");
		service.update(board);
		mav.addObject("board", board);
		return mav;
	}
	
	@RequestMapping(value = "/board/search.do")
	public ModelAndView search(String search) {
		ModelAndView mav = new ModelAndView("board/boardlist");
		List<BoardDTO> boardList = service.search(search);
		System.out.println(boardList);
		mav.addObject("boardList", boardList);
		return mav;
	}

}
