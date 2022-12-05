package com.multi.erp.board;

import java.util.List;
//BoardDAO의 메소드를 호출
//→ Controller 에게 받은 데이터를 가공해서 DAO 로 넘기거나 DAO 에서 받은 데이터를 가공해서 컨트롤러로 넘기는 작업
//→ 트랜잭션 처리

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	BoardDAO dao;
	public BoardServiceImpl() {
		
	}

	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(BoardDTO board) {
		return dao.insert(board);
	}

	@Override
	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	@Override
	public BoardDTO getBoardInfo(String board_no) {
		return dao.read(board_no);
	}

	@Override
	public int update(BoardDTO board) {
		return dao.update(board);
	}

	@Override
	public int delete(String board_no) {
		return dao.delete(board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		return dao.search(data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		return dao.search(tag, data);
	}

	@Override
	public List<BoardDTO> findByCategory(String category) {
		return dao.findByCategory(category);
	}

}
